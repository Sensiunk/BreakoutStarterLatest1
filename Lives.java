package breakoutstarter;

import java.awt.Color;
import java.awt.Graphics;

import Engine.Sprite;

public class Lives extends Sprite {
    int livesVal;

    public Lives(int livesVal) {
        xPos = 20;
        yPos = 20;
        this.livesVal = livesVal;
    }

    public void changeLives(int minusLives) {
        livesVal = livesVal - minusLives;
    }

    @Override
    public void Paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Lives: " + livesVal, (int) xPos, (int) yPos);
    }

    @Override
    public void Update(boolean[] keysPressed) {

    }
}
