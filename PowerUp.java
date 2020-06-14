package breakoutstarter;

import java.awt.Color;
import java.awt.Graphics;

import Engine.Sprite;

public class PowerUp extends Sprite {
	
	// default position of the ball.
    
    public final float defaultYPos = (Breakout.windowHeight - height) / 2;

  
    public final float defaultDY = 3;

    // Speed of the ball in the x direction. Default is 0.


    // Speed of the ball in the y direction. Default is 3.
    public float dy = 1;

    public PowerUp(int xPos, int yPos) 
    {
        width = 30;
        height = 30;
        this.xPos = xPos;
        this.yPos = yPos;
        dy = defaultDY;
        
    }

    
    public void Paint(Graphics g) {
  	  g.setColor(Color.PINK);
  	  g.fillArc((int)xPos, (int)yPos, (int)width, (int)height, 0, 180);
  }

    public void Update(boolean[] keysPressed) {
        // Move the ball at the current speed and direction it's traveling in.
        yPos = yPos + dy;
    }

}
