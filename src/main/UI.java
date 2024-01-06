package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

    GamePanel gp;
    Graphics2D g2 ;
    Font ariel_40, ariel_80B;
   /// BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";


    
    public UI(GamePanel gp) {
        this.gp = gp;

        ariel_40 = new Font("Arial", Font.PLAIN, 40);
        ariel_80B = new Font("Arial", Font.BOLD, 80);
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {
        this.g2=g2;
        g2.setFont(ariel_40);
        g2.setColor(Color.white);

        //PLAY
        if (gp.gameState == gp.playState) {

        }
        //PAUSE
        if (gp.gameState== gp.pauseState) {
                drawPauseScreen();
        }
        //DIALOGUE 
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }

    }
    
    private void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));
        String text = "PAUSED";;
        int x=getXforCenteredText(text);
        int y=gp.screenHeight/2;
        g2.drawString(text, x, y);
    }

    private void drawDialogueScreen() {

        //WINDOW
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;
        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32));
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString(currentDialogue, x, y);
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
    


