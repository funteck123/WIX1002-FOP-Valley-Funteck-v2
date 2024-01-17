package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import entity.*;
import object.*;
//import object.SuperObject;

public class UI {

    GamePanel gp;
    Graphics2D g2 ;
    Font ariel_40, ariel_80B, maruMonica, purisaB;
    BufferedImage heart_full, heart_half, heart_blank;
    // BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int  titleScreenState = 0;
    public int gameOverStateNum;

    public String fightDialogue = "";
    public String monsterAttackDialogue = "";
    public String playerAttackDialogue = "";
    public String npcAscii = "";
    
    public int monsterIndex = 0;
    public int npcNo = 0;

    public int commandNum = 0;
    public int commandNumFight = 999;
    //public boolean enterPressed = false;
    public boolean playerTurn = true;
    public boolean rewarded = false;
    public boolean initFight = true;

    
    public UI(GamePanel gp) {
        this.gp = gp;

        try {
            InputStream is = this.getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
            is = this.getClass().getResourceAsStream("/res/font/Purisa Bold.ttf");
            purisaB = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ariel_40 = new Font("Arial", Font.PLAIN, 40);
        ariel_80B = new Font("Arial", Font.BOLD, 80);

        //CREATE HUD OBJECT
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;

    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(maruMonica);
        g2.setColor(Color.white);

        // TITLE 
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();

        }
        //PLAY
        if (gp.gameState == gp.playState) {
            drawPlayerLife();
        }
        //PAUSE
        if (gp.gameState== gp.pauseState) {
            drawPlayerLife();
            drawPauseScreen();
        }
        //DIALOGUE 
        if (gp.gameState == gp.dialogueState) {
            //drawPlayerLife();
            //drawDialogueScreen();
            drawFightScreen();
        }

        //FIGHT
        if (gp.gameState == gp.characterState) {
            //drawFightScreen();
            //drawDialogueScreen();
            drawCharacterState();
        }

        if (gp.gameState == gp.gameOverState) {
            drawGameOver();
        }

        if (gp.gameState == gp.fightState) {
            //drawFightScreen();
            //drawDialogueScreen();
        }
        
    }

    public void drawTitleScreen() {
        if (titleScreenState == 0) {
            // BACKGROUND
            g2.setColor(new Color(0,0,0));
            g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

            // TITLE SCREEN
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
            String text = "FOP Valley Funteck";
            int x = getXforCenteredText(text);
            int y = gp.tileSize*2;

            // SHADOW
            g2.setColor(Color.red);
            //g2.setColor(new Color(0,250,250));
            g2.drawString(text,x+5,y+5);


            // MAIN COLOR
            //g2.setColor(Color.red);
            g2.setColor(new Color(0,250,250));
            g2.drawString(text,x,y);

            // IMAGE
            x = gp.screenWidth/2 - (gp.tileSize*10)/2;
            y += gp.tileSize;
            //BufferedImage down1 = gp.player.setup("/res/player/" + "intro_slime");
            BufferedImage down1;
            try {
                down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/intro_slime.png"));
                g2.drawImage(down1, x, y, gp.tileSize*10, gp.tileSize*5, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            x = gp.screenWidth/2 - (gp.tileSize*15)/2;
            y = gp.tileSize*11;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,23f));
            g2.setColor(Color.white);
            text = "(Controls: WASD to move, \nENTER to interact, Esc to Exit.)";
            if (text != null) {
                for (String line : text.split("\n")) {
                    g2.drawString(line, x, y);
                    y += g2.getFontMetrics().getHeight();
                }
            }

            //reset
            x = gp.screenWidth/2 - (gp.tileSize*10)/2;
            y = gp.tileSize*4;

            // //ASCII
            // g2.setColor(Color.white);
            // g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
            // int x1 = gp.tileSize*1 + gp.tileSize*8;
            // int y1 = gp.tileSize/2 + gp.tileSize;

            // npcAscii = "\\****__              ____                                              \r\n" + //
            //         "|    *****\\_      --/ *\\-__                                          \r\n" + //
            //         "/_          (_    ./ ,/----'                                         \r\n" + //
            //         "     \\__         (_./  /                                                \r\n" + //
            //         "       \\__           \\___----^__                                       \r\n" + //
            //         "          _/   _                  \\                                      \r\n" + //
            //         "   |    _/  __/ )\\\"\\ _____         *\\                                    \r\n" + //
            //         "   |\\__/   /    ^ ^       \\____      )                                   \r\n" + //
            //         "    \\___--\"                    \\_____ \r\n" + //
            //         "";

            // if (npcAscii != null) {
            //     for (String line : npcAscii.split("\n")) {
            //         g2.drawString(line, x1, y1);
            //         y1 += g2.getFontMetrics().getHeight();
            //     }
            // }

            // MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48));
            g2.setColor(Color.white);

            text = "NEW GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize*5.25;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.setColor(Color.red);
                g2.drawString(">", x-gp.tileSize/2, y);
            }

            g2.setColor(Color.white);

            text = "LOAD GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.setColor(Color.green);
                g2.drawString(">", x-gp.tileSize/2, y);
            }

            g2.setColor(Color.white);

            text = "QUIT";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.setColor(Color.blue);
                g2.drawString(">", x-gp.tileSize/2, y);
            }                                                                          
    
        } else if (titleScreenState == 1) {
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));

            String text = "What kind of hero are you?";
            int x = getXforCenteredText(text);
            int y = gp.screenHeight / 4 - gp.tileSize;
            g2.drawString(text, x, y);

            String[] classes = {"Archer", "Mage", "Paladin", "Rogue", "Warrior"};
            for (int i = 0; i < classes.length; i++) {
                x = getXforCenteredText(classes[i]);
                y = gp.screenHeight / 3 + (gp.tileSize * (i+1));
                g2.drawString(classes[i], x, y);

                if (commandNum == i) {
                    g2.setColor(Color.red);
                    g2.drawString(">", x - gp.tileSize / 2, y);
                    g2.setColor(Color.white);
                }
            }
        }        
    }


    public void drawPlayerLife() {
        // int x = gp.tileSize/2;
        // int y = gp.tileSize/2;
        int y = gp.tileSize/2;
        int x = gp.tileSize*3 + 10;
        int i = 0;

        //Draw max life
        while (i < gp.player.life/100) {
            g2.drawImage(heart_blank, x, y, null);
            x += gp.tileSize;
            i++;
        }

        // x = gp.tileSize/2;
        y = gp.tileSize/2;
        x = gp.tileSize*3 + 10;
        // y = gp.tileSize+15;
        i = 0;

        //Draw max life
        while (i < gp.player.life/50) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if (i < gp.player.life/50) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }

        String text ="";
        // //Draw player Life
        // g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50));
        // g2.setColor(Color.white);
        // x = gp.screenWidth/2 - (gp.tileSize*14)/2;
        // y = gp.tileSize*2;
        // text = "HP: " + gp.player.life;
        // g2.drawString(text, x, y);

        //Draw player level
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));
        g2.setColor(Color.yellow);
        // x = gp.tileSize*6;
        y = gp.tileSize+15;
        x = gp.tileSize/2;
        // y = gp.tileSize/2;
        text = "Level: " + gp.player.level;
        g2.drawString(text, x, y);

        //Draw help commands
        helpText("P to pause, \nS to save game,  \nC to character menu, \nEnter to interact. \nEsc to exit game.");

    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));
        String text = "PAUSED";;
        int x=getXforCenteredText(text);
        int y=gp.screenHeight/2;
        g2.drawString(text, x, y);
        
        //helpText("Press Enter.");
    }

    public void drawDialogueScreen() {


        //WINDOW
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;
        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25));
        x += gp.tileSize;
        y += gp.tileSize;

        if (currentDialogue != null) {
            for (String line : currentDialogue.split("\n")) {
                g2.drawString(line, x, y);
                y += g2.getFontMetrics().getHeight();
            }
        }

        

        
    }

    public void drawGameOver() {
        //WINDOW
        int x = gp.tileSize*1;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*2);
        int height = gp.tileSize*11;
        drawSubWindow(x, y, width, height);

        //collison
        //npcIndex = gp.cChecker.checkEntity(gp.player, gp.npc);

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20));
        x += gp.tileSize;
        y += gp.tileSize*0.75;

        if (gameOverStateNum == 0) { 
            if (rewarded != true) {

                int oldLevel = gp.player.level;

                gp.player.exp += gp.npc[npcNo].expReward;

                if (gp.player.exp > 250) {
                    gp.player.level = 10 + (gp.player.exp-250) / 50;
                } else {
                    gp.player.level = gp.player.exp / 25;
                }


                for (int i = 0; i<3; i++) {
                    if (gp.player.level >= gp.player.spellRequirement[i]) {
                        gp.player.spellUnlocked[i] = "Unlocked";
                    } else {
                        gp.player.spellUnlocked[i] = "Locked";
                    }
                }


                int newLevel = gp.player.level;
                int levelDifference = newLevel - oldLevel;

                gp.player.maxLife += gp.player.maxLife * levelDifference * (gp.player.maxLifeFactor)/20;
                gp.player.maxMana += gp.player.maxMana * levelDifference * (gp.player.maxManaFactor)/20;
                gp.player.maxDefense += gp.player.maxDefense * levelDifference * (gp.player.maxDefenseFactor)/20;
                gp.player.maxMagicalDefense += gp.player.maxMagicalDefense * levelDifference * (gp.player.maxMagicalDefenseFactor)/20;
                gp.player.maxAttack += gp.player.maxAttack * levelDifference * (gp.player.maxAttackFactor)/20; 
                gp.player.maxMagicalAttack +=  gp.player.maxMagicalAttack * levelDifference * (gp.player.maxMagicalAttackFactor)/20;
                gp.player.heal += gp.player.heal/20;

                gp.player.life = gp.player.maxLife;
                gp.player.attack = gp.player.maxAttack;
                gp.player.mana = gp.player.maxMana;
                gp.player.magicalAttack = gp.player.maxMagicalAttack;
                gp.player.defense = gp.player.maxDefense;
                gp.player.magicalDefense = gp.player.maxMagicalDefense;

            }

            rewarded = true;

            String characterStatsMenu  = 
            "+-------------------------------------------------------------+\r\n" +
            "> " + "Character Stats" + "\r\n" +
            "\r\n" +
            "Player: " + gp.keyH.characterName + "\r\n" +
            "--> HP: " + gp.player.life + " / " + gp.player.maxLife + "\r\n" +
            "--> MP: " + gp.player.mana + " / " + gp.player.maxMana + "\r\n" +
            "--> Attack: " + gp.player.attack + "\r\n" +
            "--> Magical Attack: " + gp.player.magicalAttack + "\r\n" +
            "--> Defense: " + gp.player.defense + "\r\n" +
            "--> Magical Defense: " + gp.player.magicalDefense + "\r\n\n" +
            "--> Level: " + gp.player.level + "\r\n" +
            "+-------------------------------------------------------------+\r\n\n" +
            ">> Spells\r\n" +
            "[1] " + gp.player.spellName[0] + " <" + gp.player.spellUnlocked[0] + " - Level: " + gp.player.spellRequirement[0] + " +>\r\n" +
            "[2] " + gp.player.spellName[1] + " <" + gp.player.spellUnlocked[1] + " - Level: " + gp.player.spellRequirement[1] + " +>\r\n" +
            "[3] " + gp.player.spellName[2] + " <" + gp.player.spellUnlocked[2] + "- Level: " + gp.player.spellRequirement[2] + " +>\r\n" +
            "+-------------------------------------------------------------+\r\n" +
            "";



            g2.setColor(Color.green);
            // x = gp.screenWidth/2 - gp.tileSize*6;
            // y += gp.tileSize;

            if (characterStatsMenu != null) {
                for (String line : characterStatsMenu .split("\n")) {
                    g2.drawString(line, x, y);
                    y += g2.getFontMetrics().getHeight();
                }
            }

            helpText("Press Enter.");
            
        } else if (gameOverStateNum == 1) {
            gp.player.exp = 1;
            String text = "You died. Game over! \n\n\nReturn to the title screen to \nrestart or load a save game.";
            g2.setColor(Color.red);
            x = gp.screenWidth/2 - gp.tileSize*6;
            y += gp.tileSize;

            if (text != null) {
                for (String line : text.split("\n")) {
                    g2.drawString(line, x, y);
                    y += g2.getFontMetrics().getHeight();
                }
            }

            helpText("Press Enter.");

        } else if (gameOverStateNum == 2) {

            String text = "You have barely escaped. \n\n\n\"I learned that courage was not \nthe absence of fear, \nbut the triumph over it.\" ";
            g2.setColor(Color.yellow);
            x = gp.screenWidth/2 - gp.tileSize*6;
            y += gp.tileSize;

            if (text != null) {
                for (String line : text.split("\n")) {
                    g2.drawString(line, x, y);
                    y += g2.getFontMetrics().getHeight();
                }
            }

            helpText("Press Enter.");
        }

        playerTurn = true;
        initFight = true;
        gp.ui.monsterAttackDialogue = "";
        gp.ui.playerAttackDialogue = "";
        
    }

    public void drawFightScreen() {

        //WINDOW
        int x = gp.tileSize*1;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*2);
        int height = gp.tileSize*11;
        drawSubWindow(x, y, width, height);

        //collison
        //npcIndex = gp.cChecker.checkEntity(gp.player, gp.npc);

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20));
        x += gp.tileSize;
        y += gp.tileSize*0.75;

        if (initFight) {
            monsterAttackDialogue = gp.npc[npcNo].description;
            playerAttackDialogue = "You have encountered a/an " + gp.npc[npcNo].name + ". What do you do?";
            initFight = false;
        }

        fightDialogue = "> " + monsterAttackDialogue + "\r\n" + //
                "\r\n" + //
                "Monster:"+ gp.npc[npcNo].name +"\r\n" + //
                "--> HP: " + gp.npc[npcNo].life + " / " + gp.npc[npcNo].maxLife + "\r\n" + //
                "--> MP: " + gp.npc[npcNo].mana + " / " + gp.npc[npcNo].maxMana + "\r\n" +  //
                "\r\n" + //
                "> " + playerAttackDialogue + "\r\n" + //
                "\r\n" + //
                "Player: " + gp.keyH.characterName + "\r\n" + //
                "--> HP: "+ gp.player.life + " / " + gp.player.maxLife + "\r\n" + //
                "--> MP: "+ gp.player.mana + " / " + gp.player.maxMana + "\r\n" + //
                "+-------------------------------------------------------------+\r\n" + //
                ">> Starter\r\n" + //
                "[W] Attack\r\n" + //
                "[A] Defend\r\n" + //
                "[S] Heal    \n" + //
                "[D] Escape\r\n" + //
                "\r" + //
                ">> Spells\r\n" + //
                "[1] " + gp.player.spellName[0] + " <" + gp.player.spellUnlocked[0] + " - Level: " + gp.player.spellRequirement[0] + " - Cooldown: " + gp.player.spellCooldownOn[0] + " turns>\r\n" +
                "[2] " + gp.player.spellName[1] + " <" + gp.player.spellUnlocked[1] + " - Level: " + gp.player.spellRequirement[1] + " - Cooldown: " + gp.player.spellCooldownOn[1] + " turns>\r\n" +
                "[3] " + gp.player.spellName[2] + " <" + gp.player.spellUnlocked[2] + "- Level: " + gp.player.spellRequirement[2] + " - Cooldown: " + gp.player.spellCooldownOn[2] + " turns>\r\n" +
                "+-------------------------------------------------------------+\r\n" + //
                "";


        int j = 0;
        if (fightDialogue != null) {
            for (String line : fightDialogue.split("\n")) {
                if (j<=5) {
                    g2.setColor(Color.red);
                } else {
                    g2.setColor(Color.white);
                }
                g2.drawString(line, x, y);
                y += g2.getFontMetrics().getHeight();
                j++;
            }
        }
        
        g2.setColor(Color.RED);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20));
        x = gp.tileSize*1 + gp.tileSize*8;
        y = gp.tileSize/2 + gp.tileSize;

        npcAscii = "\\****__              ____                                              \r\n" + //
                "|    *****\\_      --/ *\\-__                                          \r\n" + //
                "/_          (_    ./ ,/----'                                         \r\n" + //
                "     \\__         (_./  /                                                \r\n" + //
                "       \\__           \\___----^__                                       \r\n" + //
                "          _/   _                  \\                                      \r\n" + //
                "   |    _/  __/ )\\\"\\ _____         *\\                                    \r\n" + //
                "   |\\__/   /    ^ ^       \\____      )                                   \r\n" + //
                "    \\___--\"                    \\_____ \r\n" + //
                "";

        if (gp.npc[npcNo].asciiArt != null) {
            for (String line : gp.npc[npcNo].asciiArt.split("\n")) {
                g2.drawString(line, x, y);
                y += g2.getFontMetrics().getHeight();
            }
        }
       

        switch (commandNumFight) {
            case 0:
                if (playerTurn) {
                    gp.player.playerAttack(npcNo);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                    //helpText("Press Enter.");

                    for (int i = 0; i<3; i++) {
                        gp.player.spellCooldownOn[i] = Math.max(0,gp.player.spellCooldownOn[i]-1);
                    }
                } 
                break;
            case 1:
                if (playerTurn) {
                    gp.player.playerDefend(npcNo);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                    //helpText("Press Enter.");
                    for (int i = 0; i<3; i++) {
                        gp.player.spellCooldownOn[i] = Math.max(0,gp.player.spellCooldownOn[i]-1);
                    }
                } 
                break;
            case 2:
                if (playerTurn) {
                    gp.player.playerHeal(npcNo);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                    //helpText("Press Enter.");
                    for (int i = 0; i<3; i++) {
                        gp.player.spellCooldownOn[i] = Math.max(0,gp.player.spellCooldownOn[i]-1);
                    }                
                } 
                break;
            case 3:
                if (playerTurn) {
                    gp.player.playerRun(npcNo);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                    //helpText("Press Enter.");
                    for (int i = 0; i<3; i++) {
                        gp.player.spellCooldownOn[i] = Math.max(0,gp.player.spellCooldownOn[i]-1);
                    }                
                } 
            case 4:
                if (playerTurn) {
                    gp.player.playerSpellAttack(npcNo, commandNumFight-4);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                    //helpText("Press Enter.");
                    for (int i = 0; i<3; i++) {
                        if (i != commandNumFight-4) {
                            gp.player.spellCooldownOn[i] = Math.max(0,gp.player.spellCooldownOn[i]-1);
                        }
                    }  
                } 
            case 5:
                if (playerTurn) {
                    gp.player.playerSpellAttack(npcNo, commandNumFight-4);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                    //helpText("Press Enter.");
                    for (int i = 0; i<3; i++) {
                        if (i != commandNumFight-4) {
                            gp.player.spellCooldownOn[i] = Math.max(0,gp.player.spellCooldownOn[i]-1);
                        }
                    }  
                }
                      
                break;
            case 6:
                if (playerTurn) {
                    gp.player.playerSpellAttack(npcNo, commandNumFight-4);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                    //helpText("Press Enter.");
                    for (int i = 0; i<3; i++) {
                        if (i != commandNumFight-4) {
                            gp.player.spellCooldownOn[i] = Math.max(0,gp.player.spellCooldownOn[i]-1);
                        }
                    }  
                }
        } 
        
        
        


        if (gp.keyH.enterPressed && !playerTurn) {
            gp.player.monsterAttack(npcNo);
            playerTurn = true;
            gp.keyH.enterPressed = false;
        } 

        if (playerTurn) {
            helpText("Your turn.\nChoose an option.");
        } else {
            helpText("Monster's turn\nPress Enter.");
        }

        commandNumFight = 999;    
        


                
    }

    public void helpText(String text) {
        int helpX = gp.screenWidth/2 + (gp.tileSize*7)/2;
        int helpY = gp.screenHeight/2 + gp.tileSize*4;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20f));
        g2.setColor(new Color(0,255,0));

        if (text != null) {
            for (String line : text.split("\n")) {
                g2.drawString(line, helpX, helpY);
                helpY += g2.getFontMetrics().getHeight();
            }
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        
        Color c = new Color(0, 0, 0, 220);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x, y, width, height, 35, 35);

    }

    public void drawCharacterState() {
        //WINDOW
        int x = gp.tileSize*1;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*2);
        int height = gp.tileSize*11;
        drawSubWindow(x, y, width, height);

        //collison
        //npcIndex = gp.cChecker.checkEntity(gp.player, gp.npc);

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20));
        x += gp.tileSize;
        y += gp.tileSize*0.75;

        String characterStatsMenu  = 
        "+-------------------------------------------------------------+\r\n" +
        "> " + "Character Stats" + "\r\n" +
        "\r\n" +
        "Player: " + gp.keyH.characterName + "\r\n" +
        "--> HP: " + gp.player.life + " / " + gp.player.maxLife + "\r\n" +
        "--> MP: " + gp.player.mana + " / " + gp.player.maxMana + "\r\n" +
        "--> Attack: " + gp.player.attack + "\r\n" +
        "--> Magical Attack: " + gp.player.magicalAttack + "\r\n" +
        "--> Defense: " + gp.player.defense + "\r\n" +
        "--> Magical Defense: " + gp.player.magicalDefense + "\r\n\n" +
        "--> Level: " + gp.player.level + "\r\n" +
        "--> Exp Earned: " + gp.npc[npcNo].expReward + "\r\n" +
        "--> Next Level Exp: " + gp.player.nextLevelExp[gp.player.level] + "\r\n" +
        "+-------------------------------------------------------------+\r\n" +
        ">> Spells\r\n" +
        "[1] " + gp.player.spellName[0] + " <" + gp.player.spellUnlocked[0] + " - Level: " + gp.player.spellRequirement[0] + " +>\r\n" +
        "[2] " + gp.player.spellName[1] + " <" + gp.player.spellUnlocked[1] + " - Level: " + gp.player.spellRequirement[1] + " +>\r\n" +
        "[3] " + gp.player.spellName[2] + " <" + gp.player.spellUnlocked[2] + "- Level: " + gp.player.spellRequirement[2] + " +>\r\n" +
        "+-------------------------------------------------------------+\r\n" +
        "";



        g2.setColor(Color.green);
        // x = gp.screenWidth/2 - gp.tileSize*6;
        // y += gp.tileSize;

        if (characterStatsMenu != null) {
            for (String line : characterStatsMenu .split("\n")) {
                g2.drawString(line, x, y);
                y += g2.getFontMetrics().getHeight();
            }
        }

        //helpText("Press Enter.");
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x=gp.screenWidth/2-length/2;
       
        return x;
    }
}
    


