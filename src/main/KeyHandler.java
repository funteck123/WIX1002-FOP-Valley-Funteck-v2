package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean enterPressed = false;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // TITLE STATE
        if(gp.gameState == gp.titleState) {
            if(code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }   
            if(code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER) {
                switch(gp.ui.commandNum) {
                    case 0: gp.gameState = gp.playState; break;
                    //case 1: gp.gameState = gp.helpState; break;
                    case 2: System.exit(0); break;
                }
            }
        }
        // PLAY STATE
        if(gp.gameState == gp.playState) {
            if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if(code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if(code == KeyEvent.VK_C) {
                gp.gameState = gp.characterState;
            }
            if(code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
        }

        // PAUSE STATE
        if(gp.gameState == gp.pauseState) {
            if(code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        }
        
        // DIALOGUE STATE
        if (gp.gameState == gp.dialogueState) {
            if(code == KeyEvent.VK_W) {
                gp.ui.commandNum = 0;
            }   
            if(code == KeyEvent.VK_A) {
                gp.ui.commandNum = 1;
            }
            if(code == KeyEvent.VK_S) {
                gp.ui.commandNum = 2;
            }
            if(code == KeyEvent.VK_D) {
                gp.ui.commandNum = 3;
            }
            if(code == KeyEvent.VK_1) {
                gp.ui.commandNum = 4;
            }   
            if(code == KeyEvent.VK_2) {
                gp.ui.commandNum = 5;
            }
            if(code == KeyEvent.VK_3) {
                gp.ui.commandNum = 6;
            }
            if(code == KeyEvent.VK_4) {
                gp.ui.commandNum = 7;
            }
            // if(code == KeyEvent.VK_ENTER) {
            //     gp.gameState = gp.playState;
            // }
        }
        

        // CHARACTER STATE
        if (gp.gameState == gp.characterState) {
            if(code == KeyEvent.VK_C) {
                gp.gameState = gp.playState;
            }
        } 

        if (gp.gameState == gp.gameOverState) {
            if(code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        } 

        else {}
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }

   
}
