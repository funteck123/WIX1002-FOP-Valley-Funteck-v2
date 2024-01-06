package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gamePanel;
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP) {
            upPressed = true;
        }
        else if(code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        else if(code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        else if(code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

   else if(code == KeyEvent.VK_P) {
            if (gamePanel.gameState==gamePanel.playState) {
                gamePanel.gameState = gamePanel.pauseState;
                
            }
            else if (gamePanel.gameState==gamePanel.pauseState) {
                gamePanel.gameState = gamePanel.playState;
                
            }
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        else if(code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        else if(code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        else if(code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

   
}
