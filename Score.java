package breakoutstarter;

import java.awt.Color;
import java.awt.Graphics;

import Engine.Sprite;

public class Score extends Sprite {
    int scoreVal;

    public Score(int scoreVal) {
        xPos = Breakout.windowWidth - 100;
        yPos = 20;
        this.scoreVal = scoreVal;
    }

    public void changeScore(int plusScore) {
        scoreVal = scoreVal + plusScore;
    }

    @Override
    public void Paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Score: " + scoreVal, (int) xPos, (int) yPos);
    }

    @Override
    public void Update(boolean[] keysPressed) {

    }
}
