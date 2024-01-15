package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
//import java.nio.Buffer;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
//import java.awt.Color;
import main.UtilityTool;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int npcIndex;
    public int objIndex;
    public int monsterIndex;
    public String npcAtkDialogue;
    public String playerAtkDialogue;
    public boolean playerWin;
    public int damageDealt;
    public int damageDealt1;
    
    int standCounter = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - gp.tileSize / 2;
        screenY = gp.screenHeight / 2 - gp.tileSize / 2;

        solidArea = new Rectangle();
        solidArea.x = 11;
        solidArea.y = 18;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        solidArea.width = 26;
        solidArea.height = 26;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";

        // Player Status
        level = 1;
        maxLife = 300;
        
        life = maxLife;
        maxAttack = 2;
        maxMana = 1000;
        mana = maxMana;
        maxMagicalAttack = 2;
        maxDefense = 2;
        maxMagicalDefense = 3;
        attack = maxAttack;
        magicalAttack = maxMagicalAttack;
        defense = maxDefense;
        magicalDefense = maxMagicalDefense;
        heal = 10;

        strength=1; // the more strength he has, moredamage he given
        dexterity=1; // the more dexterity he has, the less damage he receive
        exp=0;
        nextLevelExp=5;
        coin=0;
        
        //attack=getAttack(); // the total attack value is decided by strength and weapon
        //defense=getDefense(); // the total defense value is decided by dexterity and shield
    }

//    public int getAttack() {
//         return attack=strength;
//     }

//     public int getDefense() {
//         return defense= dexterity;
//     }

    public void update() {

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.enterPressed) {

            if (keyH.upPressed && keyH.leftPressed) {
                direction = "left";
                // worldY -= speed;
                // worldX -= speed;
            } else if (keyH.upPressed && keyH.rightPressed) {
                direction = "right";
                // worldY -= speed;
                // worldX += speed;
            } else if (keyH.downPressed && keyH.leftPressed) {
                direction = "left";
                // worldY += speed;
                // worldX -= speed;
            } else if (keyH.downPressed && keyH.rightPressed) {
                direction = "right";
                // worldY += speed;
                // worldX += speed;
            } else if (keyH.upPressed) {
                direction = "up";
                // worldY -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                // worldY += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                // worldX -= speed;
            } else if (keyH.rightPressed) {
                direction = "right";
                // worldX += speed;
            }

            // Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // If Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Check Object Collision
            objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // Check NPC Collision
            npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            // check NPC collision
            monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            //interactMonster(monsterIndex);

            // check event
            gp.eHandler.checkEvent();
            gp.keyH.enterPressed = false;

            // If Collision is false, player moves
            if (collisionOn == false && keyH.enterPressed == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            gp.keyH.enterPressed = false;

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }

    }

    public BufferedImage setup(String iamgePath) {
        UtilityTool uTool = new UtilityTool();
         BufferedImage image = null;
         try {
             image = ImageIO.read(getClass().getResourceAsStream( iamgePath + ".png"));
             image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return  image;
    }
         
        

    

    public void getPlayerImage() {

        up1 = setup("/res//player/boy_up_1");
        up2 = setup("/res/player/boy_up_2");
        down1 = setup("/res/player/boy_down_1");
        down2 = setup("/res/player/boy_down_2");
        left1 = setup("/res/player/boy_left_1");
        left2 = setup("/res/player/boy_left_2");
        right1 = setup("/res/player/boy_right_1");
        right2 = setup("/res/player/boy_right_2");

    }

    public void pickUpObject(int i) {

        if (i != 999) {
        }

    }

    public void interactNPC(int i) {

        if (i != 999) {

            gp.ui.npcNo = i;

            // System.out.println("You are hitting an NPC.");
            if (gp.keyH.enterPressed == true) {
                gp.gameState = gp.dialogueState;
            }

        }

        gp.keyH.enterPressed = false;

    }

    // public void interactMonster(int i) {

    //     if (i != 999) {



    //         // System.out.println("You are hitting an NPC.");
    //         if (gp.keyH.enterPressed == true) {
    //             gp.gameState = gp.dialogueState;
    //             gp.monster[i].speak();
    //         }

    //     }

    //     gp.keyH.enterPressed = false;

    // }

    public void playerAttack(int i) {
        if (gp.player.life > 0) {
            
            Random random = new Random();
            damageDealt = random.nextInt(gp.player.attack) + 1;
            // Player's attack logic
            damageDealt = gp.player.attack;
            gp.npc[i].life = Math.max(0, gp.npc[i].life - damageDealt);

            gp.ui.playerAttackDialogue = "You attacked the " + gp.npc[i].name + " with " + damageDealt + "!";

            damageDealt = 0;

            if (gp.npc[i].life <= 0) {
                // If not defeated, let the monster attack
                gp.ui.monsterAttackDialogue = "The " + gp.npc[i].name + " has been slain!";
            } 
            
        } else {

            gp.gameState = gp.gameOverState;
            playerWin = false;
            gp.ui.monsterAttackDialogue = "";
            gp.ui.playerAttackDialogue = "";
        
        }
    }

    public void playerDefend(int i) {
        if (gp.player.life > 0) {
            
            // Player's attack logic
            gp.ui.playerAttackDialogue = "You put " + gp.player.defense + " defense!";

            damageDealt1 = gp.player.defense;

        }   else {
            gp.gameState = gp.gameOverState;
            playerWin = false;
            gp.ui.monsterAttackDialogue = "";
            gp.ui.playerAttackDialogue = "";
        }
    }

    public void playerHeal(int i) {
        if (gp.player.life > 0) {
            
            // Player's attack logic
            gp.player.life += gp.player.heal;
            gp.player.life = Math.min(gp.player.maxLife, gp.player.life);

            gp.ui.playerAttackDialogue = "You healed with " + gp.player.heal + "! Refreshing, right?";

        }   else {
            gp.gameState = gp.gameOverState;
            playerWin = false;
            gp.ui.monsterAttackDialogue = "";
            gp.ui.playerAttackDialogue = "";

        }
    }


    public void playerRun(int i) {
        gp.gameState = gp.gameOverState;
        playerWin = false;
        gp.ui.monsterAttackDialogue = "";
        gp.ui.playerAttackDialogue = "";

    }

    public void monsterAttack(int i) {
        // Check if the monster is defeated
        if (gp.npc[i].life > 0) {
            // If not defeated, let the monster attack
            damageDealt = gp.npc[i].npcAttack(i);
            gp.player.life -= Math.max(0,damageDealt - damageDealt1);
            gp.ui.monsterAttackDialogue = "The " + gp.npc[i].name + " attacked you with " + damageDealt + "!";
            damageDealt = 0;
            damageDealt1 = 0;
        } else {
            // Handle victory, gain experience, etc.
            gp.ui.playerAttackDialogue = "You defeated the " + gp.npc[i].name + " !";
            playerWin = true;
            gp.gameState = gp.gameOverState;
            gp.ui.monsterAttackDialogue = "";
            gp.ui.playerAttackDialogue = "";
            gp.npc[i].worldX = -10;
            gp.npc[i].worldX = -10;           

        }
    }




    

















    
    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
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
        g2.drawImage(image, screenX, screenY, null);

    }

}
