package breakoutstarter;

import Engine.Game;
import Engine.GameController;
import Engine.Sprite;
import java.util.Random;

import java.util.ArrayList;

// The entry point for the breakout game. Implements game controller so we can get
// notified after each frame is drawn.
public class Breakout implements GameController {

	// The width of the window.
	public static int windowWidth = 512;

	// The height of the window.
	public static int windowHeight = 512;

	// The game object that controls the running of the game.
	public Game game;

	// The ball sprite.
	public Ball ball;

	public Paddle paddle;

	public DeathBar deathBar;

	public Score score;

	public Lives lives;
	
	public Levels level;
	
	public PowerUp power = new PowerUp(0,0);
	
	// Starts the game.
	public void Start() {
		// Create the ball sprite and add it to the games sprites.
		ball = new Ball();
		game.addSprite(ball);

		paddle = new Paddle();
		game.addSprite(paddle);

		createBlocks();

		deathBar = new DeathBar();
		game.addSprite(deathBar);

		score = new Score(0);
		game.addSprite(score);

		lives = new Lives(3);
		game.addSprite(lives);
		
		level = new Levels();
		game.addSprite(level);
		

		// Run the main game loop
		game.runGameLoop();
	}

	public void createBlocks() {
		for (int x = 10; x < windowWidth; x += 73) {
			for (int y = 30; y < windowHeight / 5; y += 30) {
				game.addSprite(new Block(x, y, 60, 20));	
			}
		}
	}

	// Run each frame after the sprites have been updated.
	public void UpdateOccurred() {
		if (lives.livesVal > 0) {
			// Nothing needed here. You will need to add logic to check the state of the
			// game here.
			Sprite collidedSprite = game.checkCollision(ball);
			Sprite collidedPower = game.checkCollision(power);

			if (collidedSprite != null) {

				if (collidedSprite.getClass() == Paddle.class) {
					float midBall = ball.xPos + ball.width / 2;
					float midPaddle = paddle.xPos + paddle.width / 2;

					if (midBall > midPaddle - 10 && midBall < midPaddle + 10) {
						ball.dx = 0;
					}

					else if (midBall < midPaddle) {
						ball.dx = -1 * Math.abs(ball.dy);
					}

					else {
						ball.dx = Math.abs(ball.dy);
					}

					ball.dy = -1 * ball.dy;
				}
				
//				if (game.checkCollision(power,paddle).getClass() == Paddle.class) {
//					ball.increaseSpeed();
//				}

				if (collidedSprite.getClass() == Block.class) {
					
					for (Sprite block : game.getSprites()) {

						if (collidedSprite.equals(block)) {
							int counter = (int) (Math.random() * 5 +1);
							if (block.getYPos() == 30) {
								score.changeScore(5);
							} else if (block.getYPos() == 60) {
								score.changeScore(3);
							} else if (block.getYPos() == 90) {
								score.changeScore(1);
							}
							
							float midBall = block.xPos + block.width / 2;
							float midBlock = block.xPos + block.width / 2;

							if (midBall > midBlock - 10 && midBall < midBlock + 10) {
								ball.dx = 0;
							}

							else if (midBall < midBlock) {
								ball.dx = -1 * Math.abs(ball.dy);
							}

							else {
								ball.dx = Math.abs(ball.dy);
							}

							ball.dy = -1 * ball.dy;
							
							if (counter == 3) {
								power.setXPos((int)block.getXPos());
								power.setYPos((int)block.getYPos());
								game.addSprite(power);
							}
							
							game.removeSprite(block);
							game.addBlock(block);
							
							if (!game.doBlocksExist()) {
								if(level.getLevel() < 2) {
									level.changeLevels(1);
									game.resetLevel();
								} else {
									ball.resetPosition();
									paddle.resetPosition();
									return;
								}
							}
							
						}
					}
				}

				if (collidedSprite.getClass() == DeathBar.class) {
					ball.resetPosition();
					lives.changeLives(1);
				}

			}

		} else if (lives.livesVal <= 0) {
			ball.resetPosition();
			paddle.resetPosition();
			return;
		}
	}
}
