package breakoutstarter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import Engine.Sprite;

public class Paddle extends Sprite {
    public final float defaultXPos = (Breakout.windowWidth - this.width) / 2;

    public final float defaultYPos = Breakout.windowHeight - 30 - this.height;

    public final float paddleSpeed = 6;

    public Paddle() {
        this.height = 20;
        this.width = 100;

        resetPosition();
    }

    public void resetPosition() {
        yPos = defaultYPos;
        xPos = defaultXPos;
    }

    public void Paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int)xPos, (int)yPos, (int)width, (int)height);
    }

    public void Update(boolean[] keysPressed) {
        if (keysPressed[KeyEvent.VK_LEFT]) {
            xPos-=paddleSpeed;
        }
        if (keysPressed[KeyEvent.VK_RIGHT]) {
            xPos+=paddleSpeed;
        }

        if (this.xPos < 0) {
            xPos+=paddleSpeed;
        }

        if (this.xPos + this.width > Breakout.windowWidth) {
            xPos-=paddleSpeed;
        }
    }
}
