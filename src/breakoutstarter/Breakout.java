package breakoutstarter;

import Engine.Game;
import Engine.GameController;
import Engine.Sprite;

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

    // Starts the game.
    public void Start(){
        // Create the ball sprite and add it to the games sprites.
        ball = new Ball();
        game.addSprite(ball);

        paddle = new Paddle();
        game.addSprite(paddle);


        ArrayList<BlockTop> blocksRow1 = new ArrayList<BlockTop>();
        for (int x = 10; x < 461; x = x+73) {
            blocksRow1.add(new BlockTop(x, 30));
        }
        int counterTop = 0;
        for (BlockTop blockTop : blocksRow1)
        {
            game.addSprite(blocksRow1.get(counterTop));
            counterTop++;
        }

        ArrayList<BlockMiddle> blocksRow2 = new ArrayList<BlockMiddle>();
        for (int x = 10; x < 461; x = x+73) {
            blocksRow2.add(new BlockMiddle(x, 60));
        }
        int counterMiddle = 0;
        for (BlockMiddle blockMiddle : blocksRow2)
        {
            game.addSprite(blocksRow2.get(counterMiddle));
            counterMiddle++;
        }

        ArrayList<BlockBottom> blocksRow3 = new ArrayList<BlockBottom>();
        for (int x = 10; x < 461; x = x+73) {
            blocksRow3.add(new BlockBottom(x, 90));
        }
        int counterBottom = 0;
        for (BlockBottom blockBottom : blocksRow3)
        {
            game.addSprite(blocksRow3.get(counterBottom));
            counterBottom++;
        }

        deathBar = new DeathBar();
        game.addSprite(deathBar);

        score = new Score(0);
        game.addSprite(score);

        lives = new Lives( 3);
        game.addSprite(lives);

        // Run the main game loop
        game.runGameLoop();
    }

    // Run each frame after the sprites have been updated.
    public void UpdateOccurred() {
        if (lives.livesVal > 0) {
        // Nothing needed here. You will need to add logic to check the state of the game here.
            Sprite collidedSprite = game.checkCollision(ball);

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

//                if (collidedSprite.getClass() == Block.class) {
//                    float midBall = block.xPos + block.width / 2;
//                    float midBlock = block.xPos + block.width / 2;
//
//                    score.changeScore(1);
//
//                    if (midBall > midBlock - 10 && midBall < midBlock + 10) {
//                        ball.dx = 0;
//                    }
//
//                    else if (midBall < midBlock) {
//                        ball.dx = -1 * Math.abs(ball.dy);
//                    }
//
//                    else {
//                        ball.dx = Math.abs(ball.dy);
//                    }
//
//                    ball.dy = -1 * ball.dy;
//                }

                if (collidedSprite.getClass() == DeathBar.class) {
                    ball.resetPosition();
                    lives.changeLives(1);
                }
            }
        }
        else if (lives.livesVal <= 0) {
            ball.resetPosition();
            return;
        }
    }
}

