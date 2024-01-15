package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import entity.Entity;
import object.*;
//import object.SuperObject;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font ariel_40, ariel_80B, maruMonica, purisaB;
    BufferedImage heart_full, heart_half, heart_blank;
    // BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int selectScreenState = 0;// 0:first screen,
    public String selectedCharacter = "";

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

        // CREATE HUD OBJECT
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
        // PLAY
        if (gp.gameState == gp.playState) {
            drawPlayerLife();
        }
        // PAUSE
        if (gp.gameState == gp.pauseState) {
            drawPlayerLife();
            drawPauseScreen();
        }
        // DIALOGUE
        if (gp.gameState == gp.dialogueState) {
            drawPlayerLife();
            drawDialogueScreen();
        }

    }

    public void drawTitleScreen() {

        if (selectScreenState == 0) {

            // title name
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 120F));
            String text = "Adventure";
            int x = centerTextX(text);
            int y = gp.tileSize * 3;

            // shadow
            g2.setColor(Color.darkGray);
            g2.drawString(text, x + 5, y + 5);

            // color
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            // ASCII monster
            String wolf = """
                             __
                            /  \\__
                           (     @\\___
                           /                O
                         /    (_______/
                       /_____/
                    """;

            // Split the ASCII art into lines
            String[] wolfLines = wolf.split("\r\n|\r|\n");

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));

            // Calculate the total height of the ASCII art
            int totalHeight = wolfLines.length * g2.getFontMetrics().getHeight();

            // Calculate the total width of the ASCII art
            int totalWidth = 0;
            for (String line : wolfLines) {
                int lineWidth = g2.getFontMetrics().stringWidth(line);
                if (lineWidth > totalWidth) {
                    totalWidth = lineWidth;
                }
            }

            // Adjust x and y positions to center the ASCII art
            x = (gp.screenWidth - totalWidth) / 2;
            y = (gp.screenHeight - totalHeight) / 2;

            // Adjust spacing between characters to ensure proper orientation
            int lineHeight = g2.getFontMetrics().getHeight();
            for (String line : wolfLines) {
                g2.drawString(line, x, y);
                y += lineHeight;
            }

            // menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
            text = "New Game";
            x = centerTextX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Load Game";
            x = centerTextX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Quit";
            x = centerTextX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        } else if (selectScreenState == 1) {
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(40F));

            String[] characterNames = { "Warrior", "Mage", "Rogue", "Paladin", "Archer", "Back" };
            selectedCharacter = characterNames[commandNum];

            String text = "Select your character";
            int x = centerTextX(text);
            int y = gp.tileSize * 3;
            g2.drawString(text, x, y);

            text = "Warrior";
            x = centerTextX(text);
            y += gp.tileSize * 2;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Mage";
            x = centerTextX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Rogue";
            x = centerTextX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Paladin";
            x = centerTextX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 3) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Archer";
            x = centerTextX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 4) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Back";
            x = centerTextX(text);
            y += gp.tileSize * 2;
            g2.drawString(text, x, y);
            if (commandNum == 5) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        }
    }

    public int centerTextX(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }

    public void drawPlayerLife() {
        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;

        // Draw max life
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_blank, x, y, null);
            x += gp.tileSize;
            i++;
        }

        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        // Draw max life
        while (i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if (i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }

    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));
        String text = "PAUSED";
        ;
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() {

        // WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
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
        int x = gp.screenWidth / 2 - length / 2;

        return x;

    }
}
