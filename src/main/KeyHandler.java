package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean enterPressed = false;
    public int characterSelection;
    public String characterName;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
        //characterName = "Mage";
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        // TITLE STATE
        if (gp.gameState == gp.titleState) {
            //gp.player.getPlayerImage();
            if (gp.ui.titleScreenState == 0) {
                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 2;
                    }
                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 2) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    switch (gp.ui.commandNum) {
                        case 0:
                            gp.ui.titleScreenState = 1;
                            break;
                        // case 1: gp.gameState = gp.helpState; break;
                        case 2:
                            System.exit(0);
                            break;
                    }
                }
            } else if (gp.ui.titleScreenState == 1) {
                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 4;
                    }
                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 4) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                switch (gp.ui.commandNum) {
                    case 0:
                        characterSelection = 0;
                        characterName = "Archer";
                        //System.out.println("Do some Archer specific stuff");
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        break;
                    case 1:
                        characterSelection = 1;
                        characterName = "Mage";
                        //System.out.println("Do some Rogue specific stuff");
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        break;
                    case 2:
                        characterSelection = 2;
                        characterName = "Paladin";
                        //System.out.println("Do some Archer specific stuff");
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        break;
                    case 3:
                        characterSelection = 3;
                        characterName = "Rogue";
                        //System.out.println("Do some Mage specific stuff");
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        break;
                    case 4:
                        characterSelection = 4;
                        characterName = "Warrior";
                        //System.out.println(characterName);
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        break;
                    }
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
                gp.ui.commandNumFight = 0;
            }   
            if(code == KeyEvent.VK_A) {
                gp.ui.commandNumFight = 1;
            }
            if(code == KeyEvent.VK_S) {
                gp.ui.commandNumFight = 2;
            }
            if(code == KeyEvent.VK_D) {
                gp.ui.commandNumFight = 3;
            }
            if(code == KeyEvent.VK_1) {
                gp.ui.commandNumFight = 4;
            }   
            if(code == KeyEvent.VK_2) {
                gp.ui.commandNumFight = 5;
            }
            if(code == KeyEvent.VK_3) {
                gp.ui.commandNumFight = 6;
            }
            if(code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
        }
        

        // CHARACTER STATE
        if (gp.gameState == gp.characterState) {
            if(code == KeyEvent.VK_C) {
                gp.gameState = gp.playState;
            }
        } 

        // Game Over State
        if (gp.gameState == gp.gameOverState) {
            if(code == KeyEvent.VK_ENTER) {
                if (gp.player.playerWin == true) {
                    gp.gameState = gp.playState;
                } else {
                    gp.gameState = gp.titleState;
                    gp.ui.titleScreenState = 0;
                }
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
        enterPressed = false;
    }

   
}
