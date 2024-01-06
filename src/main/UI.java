package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {

    GamePanel gp;
    Graphics2D g2 ;
    Font ariel_40, ariel_80B;
   /// BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime = 0;
    DecimalFormat dFormat = new DecimalFormat("0.00");

    public UI(GamePanel gp) {
        this.gp = gp;

        ariel_40 = new Font("Arial", Font.PLAIN, 40);
        ariel_80B = new Font("Arial", Font.BOLD, 80);
        

        OBJ_Key key = new OBJ_Key();
       /// keyImage = key.image;
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {
this.g2=g2;
g2.setFont(ariel_40);
g2.setColor(Color.white);

if (gp.gameState == gp.playState) {
        }
          if (gp.gameState== gp.pauseState) {
            drawPauseScreen();
        }

        

    }

    private void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));
   String text = "PAUSED";;
   int x=getXforCenteredText(text);
   int y=gp.screenHeight/2;
   g2.drawString(text, x, y);
    }
    public int getXforCenteredText(String text) {
          int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
  int x=gp.screenWidth/2-length/2;
       
        return x;
        
    }
}
    


