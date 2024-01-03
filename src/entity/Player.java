package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
//import java.nio.Buffer;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
//import java.awt.Color;


public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void update() {

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
           
            if (keyH.upPressed && keyH.leftPressed) {
                direction = "left";
                y -= speed;
                x -= speed;
            } else if (keyH.upPressed && keyH.rightPressed) {
                direction = "right";
                y -= speed;
                x += speed;
            } else if (keyH.downPressed && keyH.leftPressed) {
                direction = "left";
                y += speed;
                x -= speed;
            } else if (keyH.downPressed && keyH.rightPressed) {
                direction = "right";
                y += speed;
                x += speed;
            } else if (keyH.upPressed) {
                direction = "up";
                y -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed) {
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if (spriteCounter >10) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }


        


    }

    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));



        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        
        switch(direction) {
        case "up":
            if (spriteNum == 1) {
                image = up1;
            } else {
                image = up2;
            }
            break;
        case "down":
            if (spriteNum == 1) {
                image = down1;
            } else {
                image = down2;
            }
            break;
        case "left":
            if (spriteNum == 1) {
                image = left1;
            } else {
                image = left2;
            }
            break;
        case "right":
            if (spriteNum == 1) {
                image = right1;
            } else {
                image = right2;
            }
            break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }





    
}
