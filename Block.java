package breakoutstarter;

import Engine.Sprite;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;

public class Block extends Sprite {

	Color color;

	public Block(float xPos, float yPos, float width, float height) {
		this.width = width;
		this.height = height;
	    this.xPos = xPos;
		this.yPos = yPos;
		
		if (yPos == 30) {
			color = new Color(0, 255, 0);
		} else if (yPos == 60) {
			color = new Color(255, 0, 0);
		} else if (yPos == 90) {
			color = new Color(0, 0, 255);
		}
		
	}

	public void Paint(Graphics g) {
		g.setColor(color);
		g.fillRect((int) xPos, (int) yPos, (int) width, (int) height);
	}

	public void Update(boolean[] keysPressed) {}
}
