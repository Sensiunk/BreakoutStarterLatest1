package breakoutstarter;

import Engine.Sprite;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;

public class DeathBar extends Sprite {
    public final float defaultXPos = 0;

    public final float defaultYPos = Breakout.windowHeight - 2;

    public DeathBar() {
        this.height = 1;
        this.width = Breakout.windowWidth;

        resetPosition();
    }

    public void resetPosition() {
        yPos = defaultYPos;
        xPos = defaultXPos;
    }

    public void Paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)xPos, (int)yPos, (int)width, (int)height);
    }

    public void Update(boolean[] keysPressed) {
    }
}

