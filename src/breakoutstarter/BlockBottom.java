package breakoutstarter;

import Engine.Sprite;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;

public class BlockBottom extends Sprite {
    public float defaultXPos = 10;

    public float defaultYPos = 30;

    public BlockBottom(int xPosition, int yPosition) {
        height = 20;
        width = 60;
        defaultXPos = xPosition;
        defaultYPos = yPosition;

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
    }
}

