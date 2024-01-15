package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean enterPressed = false;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // TITLE STATE
        switch (gp.ui.selectScreenState) {
            case 0:
                titleKey(code);
                break;
            case 1:
                roleSelectionKey(code);
                break;
            case 2:

                break;
            case 3:
                quit(code);
                break;
        }

        // PLAY STATE
        if (gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if (code == KeyEvent.VK_C) {
                gp.gameState = gp.characterState;
            }
            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
        }

        // PAUSE STATE
        else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        }

        // DIALOGUE STATE
        else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
            // CHARACTER STATE
            else if (gp.gameState == gp.characterState) {
                if (code == KeyEvent.VK_C) {
                    gp.gameState = gp.playState;
                }
            }
        }
    }

    public void titleKey(int code) {
        if (code == KeyEvent.VK_UP) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = 2;
            }
        }
        if (code == KeyEvent.VK_DOWN) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 2) {
                gp.ui.commandNum = 0;
            }
        }
        if (code == KeyEvent.VK_ENTER) {
            if (gp.ui.commandNum == 0) {
                gp.ui.selectScreenState = 1;
            }
            if (gp.ui.commandNum == 1) {
            }
            if (gp.ui.commandNum == 2) {
                System.exit(0);
            }
        }
    }

    public void roleSelectionKey(int code) {
        if (code == KeyEvent.VK_UP) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = 5;
            }
        }
        if (code == KeyEvent.VK_DOWN) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 5) {
                gp.ui.commandNum = 0;
            }
        }
        if (code == KeyEvent.VK_ENTER) {
            switch (gp.ui.commandNum) {
                case 0:
                    gp.player.characterName = "Warrior";
                    gp.player.changeCharacter();
                    gp.playMusic(0);
                    break;
                case 1:
                    gp.player.characterName = "Mage";
                    gp.player.loadCharacterImages();
                    gp.playMusic(0);
                    break;
                case 2:
                    gp.player.characterName = "Rogue";
                    gp.player.loadCharacterImages();
                    gp.playMusic(0);
                    break;
                case 3:
                    gp.player.characterName = "Paladin";
                    gp.player.loadCharacterImages();
                    gp.playMusic(0);
                    break;
                case 4:
                    gp.player.characterName = "Archer";
                    gp.player.loadCharacterImages();
                    gp.playMusic(0);
                    break;
                case 5:
                    gp.ui.selectScreenState = 0;
                    gp.ui.commandNum = 0;
                    break;
            }
            gp.gameState = gp.playState;
        }
    }

    public void quit(int code) {
        if (code == KeyEvent.VK_ENTER) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }

}
