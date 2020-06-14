package breakoutstarter;

import java.awt.Color;
import java.awt.Graphics;

import Engine.Sprite;

public class Levels extends Sprite {


	public Levels() {
        xPos = 216;
        yPos = 20;
    }

    public void changeLevels(int addLevel) {
    	level += addLevel;
    }

    @Override
    public void Paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Level: " + level, (int) xPos, (int) yPos);
    }

    @Override
    public void Update(boolean[] keysPressed) {

    }
}
