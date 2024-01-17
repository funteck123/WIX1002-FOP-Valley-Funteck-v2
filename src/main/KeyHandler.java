package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import entity.*;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean enterPressed = false;
    public int characterSelection;
    public String characterName;
    public boolean characterSelected = false;
    public boolean paused = false;
    public boolean characterStats = false;

    public long lastPauseToggleTime = 0;
    public long pauseToggleCooldown = 100; // Cooldown in milliseconds

    public long lastCharacterToggleTime = 0;
    public long characterToggleCooldown = 100; // Cooldown in milliseconds

    public final String PLAYER_FILE = "player.dat";

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
                        case 1: 
                            gp.saveLoad.load();
                            gp.player.getPlayerImage();
                            gp.gameState = gp.playState;
                            gp.aSetter.setNPC();
                            break;
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
                        if (characterSelected == false) {
                            characterName = "Archer";
                            characterSelected = true;
                        }
                        //System.out.println("Do some Archer specific stuff");
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        gp.aSetter.setNPC();
                        break;
                    case 1:
                        characterSelection = 1;
                        if (characterSelected == false) {
                            characterName = "Mage";
                            characterSelected = true;
                        }
                        //System.out.println("Do some Rogue specific stuff");
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        gp.aSetter.setNPC();
                        break;
                    case 2:
                        characterSelection = 2;
                        if (characterSelected == false) {
                            characterName = "Paladin";
                            characterSelected = true;
                        }
                        //System.out.println("Do some Archer specific stuff");
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        gp.aSetter.setNPC();
                        break;
                    case 3:
                        characterSelection = 3;
                        if (characterSelected == false) {
                            characterName = "Rogue";
                            characterSelected = true;
                        }
                        //System.out.println("Do some Mage specific stuff");
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        gp.aSetter.setNPC();
                        break;
                    case 4:
                        characterSelection = 4;
                        if (characterSelected == false) {
                            characterName = "Warrior";
                            characterSelected = true;
                        }
                        //System.out.println(characterName);
                        gp.player.getPlayerImage();
                        gp.player.setDefaultValues();
                        gp.gameState = gp.playState;
                        gp.aSetter.setNPC();
                        break;
                    }
                }
            }
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

            if (code == KeyEvent.VK_L) {
                gp.saveLoad.save();
                System.out.println("Player saved.");
            }
            if (code == KeyEvent.VK_P && System.currentTimeMillis() - lastPauseToggleTime > pauseToggleCooldown) {
                gp.gameState = (paused) ? gp.playState : gp.pauseState;
                paused = !paused;
                lastPauseToggleTime = System.currentTimeMillis();
            } else if (code == KeyEvent.VK_C && System.currentTimeMillis() - lastCharacterToggleTime > characterToggleCooldown) {
                gp.gameState = (characterStats) ? gp.playState : gp.characterState;
                characterStats = !characterStats;
                lastCharacterToggleTime = System.currentTimeMillis();
            }
            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            } 
            
            if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_LEFT || code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN || code == KeyEvent.VK_W || code == KeyEvent.VK_A || code == KeyEvent.VK_S || code == KeyEvent.VK_D || code == KeyEvent.VK_P || code == KeyEvent.VK_C|| code == KeyEvent.VK_L || code == KeyEvent.VK_ENTER) {
            } else {
                String keyText = KeyEvent.getKeyText(code);
                System.out.println("Key Pressed: " + keyText + "\"P to pause, \\n" + //
                        "S to save game,  \\n" + //
                        "C to character menu, \\n" + //
                        "Enter to interact. \\n" + //
                        "Esc to exit game.\"");
            }


        }

        // PAUSE STATE
        if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P && System.currentTimeMillis() - lastPauseToggleTime > pauseToggleCooldown) {
                gp.gameState = gp.playState;
                paused = false;
                lastPauseToggleTime = System.currentTimeMillis();
            }
        }

        // CHARACTER STATE
        if (gp.gameState == gp.characterState) {
            if (code == KeyEvent.VK_C && System.currentTimeMillis() - lastCharacterToggleTime > characterToggleCooldown) {
                gp.gameState = gp.playState;
                characterStats = false;
                lastCharacterToggleTime = System.currentTimeMillis();
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

                if(gp.player.spellCooldownOn[0] == 0 && gp.player.spellUnlocked[0] == "Unlocked") {
                    gp.ui.commandNumFight = 4;
                }

            }   
            if(code == KeyEvent.VK_2) {

                if(gp.player.spellCooldownOn[1] == 0 && gp.player.spellUnlocked[1] == "Unlocked") {
                    gp.ui.commandNumFight = 5;
                }

            }
            if(code == KeyEvent.VK_3) {

                if(gp.player.spellCooldownOn[2] == 0 && gp.player.spellUnlocked[2] == "Unlocked") {
                    gp.ui.commandNumFight = 6;
                }

            }
            if(code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
        }
        


        // Game Over State
        if (gp.gameState == gp.gameOverState) {
            if(code == KeyEvent.VK_ENTER) {
                if (gp.ui.gameOverStateNum == 0) {
                    gp.gameState = gp.playState;
                } else if (gp.ui.gameOverStateNum == 1) {
                    gp.gameState = gp.titleState;
                    gp.ui.titleScreenState = 0;
                    characterSelected = false;
                } else if (gp.ui.gameOverStateNum == 2) {
                    gp.gameState = gp.playState;
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
