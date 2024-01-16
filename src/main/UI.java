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

    public String fightDialogue = "";
    public String monsterAttackDialogue = "";
    public String playerAttackDialogue = "";
    public String npcAscii = "";
    
    public int monsterIndex = 0;
    public int npcNo = 0;

    public int commandNum = 0;
    public int commandNumFight = 5;
    //public boolean enterPressed = false;
    public boolean playerTurn = false;


    
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
        if (gp.gameState == gp.fightState) {
            //drawFightScreen();
            //drawDialogueScreen();
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
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,25f));
            g2.setColor(Color.white);
            text = "(Controls: WASD to \nmove, ENTER to interact.)";
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
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        //Draw max life
        while (i < gp.player.maxLife/50) {
            g2.drawImage(heart_blank, x, y, null);
            x += gp.tileSize;
            i++;
        }

        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        //Draw max life
        while (i < gp.player.life/25) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if (i < gp.player.life/25) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }

    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));
        String text = "PAUSED";;
        int x=getXforCenteredText(text);
        int y=gp.screenHeight/2;
        g2.drawString(text, x, y);
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

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));

        if (gp.player.playerWin == true) {
            String text = "YOU WIN";;
            int x=getXforCenteredText(text);
            int y=gp.screenHeight/2;
            g2.drawString(text, x, y);
        } else {
            String text = "GAME OVER";;
            int x=getXforCenteredText(text);
            int y=gp.screenHeight/2;
            g2.drawString(text, x, y);
        }
        
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
        y += gp.tileSize;

        fightDialogue = "> "+ monsterAttackDialogue + "\r\n" + //
                "\r\n" + //
                ""+ gp.npc[npcNo].name +"\r\n" + //
                "--> HP: " + gp.npc[npcNo].life + " / " + gp.npc[npcNo].maxLife + "\r\n" + //
                "--> MP: " + gp.npc[npcNo].mana + " / " + gp.npc[npcNo].maxMana + "\r\n" +  //
                "\r\n" + //
                "> " + playerAttackDialogue + "\r\n" + //
                "\r\n" + //
                "Player: Warrior\r\n" + //
                "--> HP: "+ gp.player.life + " / " + gp.player.maxLife + "\r\n" + //
                "--> MP: "+ gp.player.mana + " / " + gp.player.maxMana + "\r\n" + //
                "+-------------------------------------------------------------+\r\n" + //
                ">> Starter\r\n" + //
                "[W] Attack\r\n" + //
                "[A] Defend\r\n" + //
                "[S] Heal    \n" + //
                "[D] Escape\r\n" + //
                "\r\n" + //
                ">> Spells\r\n" + //
                "[1] Rabid Lunge  \n" + //
                "[2] <Locked - 10>\r\n" + //
                "[3] <Locked - 15>\r\n" + //
                "+-------------------------------------------------------------+\r\n" + //
                "";

        if (fightDialogue != null) {
            for (String line : fightDialogue.split("\n")) {
                g2.drawString(line, x, y);
                y += g2.getFontMetrics().getHeight();
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

        if (npcAscii != null) {
            for (String line : npcAscii.split("\n")) {
                g2.drawString(line, x, y);
                y += g2.getFontMetrics().getHeight();
            }
        }
       

        switch (commandNum) {
            case 0:
                if (playerTurn) {
                    gp.player.playerAttack(npcNo);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                } 
                break;
            case 1:
                if (playerTurn) {
                    gp.player.playerDefend(npcNo);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                } 
                break;
            case 2:
                if (playerTurn) {
                    gp.player.playerHeal(npcNo);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                } 
                break;
            case 3:
                if (playerTurn) {
                    gp.player.playerRun(npcNo);
                    playerTurn = false;
                    gp.keyH.enterPressed = false;
                } 
                
                break;
            case 4:
                // Handle case 4
                break;
        } 
        
        commandNum = 5;

        if (gp.keyH.enterPressed && !playerTurn) {
            gp.player.monsterAttack(npcNo);
            playerTurn = true;
            gp.keyH.enterPressed = false;
        }
        
        


                
        }



    public void drawSubWindow(int x, int y, int width, int height) {
        
        Color c = new Color(0, 0, 0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x, y, width, height, 35, 35);

    }


    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x=gp.screenWidth/2-length/2;
       
        return x;
    }
}
    


