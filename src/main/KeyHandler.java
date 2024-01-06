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
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            upPressed = true;
        }
        else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            downPressed = true;
        }
        else if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
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

        if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            upPressed = false;
        }
        else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            downPressed = false;
        }
        else if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }

   
}
