package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import object.OBJ_Heart;
import object.SuperObject;

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


    
    public UI(GamePanel gp) {
        this.gp = gp;

        try {
            InputStream is = this.getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
            is = this.getClass().getResourceAsStream("/res/font/Purisa-BoldOblique.ttf");
            purisaB = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ariel_40 = new Font("Arial", Font.PLAIN, 40);
        ariel_80B = new Font("Arial", Font.BOLD, 80);

        //CREATE HUD OBJECT
        SuperObject heart = new OBJ_Heart(gp);
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
            drawPlayerLife();
            drawDialogueScreen();
        }

    }

    public void drawPlayerLife() {
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        while (i < gp.player.life/2) {
            g2.drawImage(heart_blank, x, y, null);
            x += gp.tileSize;
            i++;
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
    


