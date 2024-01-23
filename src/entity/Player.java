package entity;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;
//import java.nio.Buffer;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
//import java.awt.Color;
import main.UtilityTool;

public class Player extends Entity implements Serializable {

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
    //public String characterName;
    
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

        //getPlayerImage();

    }


    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";

        // Player Status

        level = 1;
        
        //spells.readSpellFile("spells.txt");

        switch (gp.keyH.characterSelection) {
            case 0:
                gp.keyH.characterName = "Archer";

                spellName = new String[]{"Rapid Shot", "Trick Shot", "Smoke Bomb"};
                spellRequirement = new int[]{10, 15, 22};
                spellCooldown = new int[]{2, 6, 5};
                spellMana = new int[]{8, 17, 20};
                spellMagicalAttack = new int[]{0, 0, 0}; // Fill with random values
                spellMagicalDef = new int[]{0, 0, 0}; // Fill with random values
                spellDescription = new String[]{
                    "Hurls a fiery projectile at the target, \ndealing moderate fire damage.",
                    "Engulfs the target in a raging inferno, \ndealing continuous fire damage for 3 rounds.",
                    "The Mage releases a burst of frost, \nfreezing nearby enemies in place for 2 rounds."
                };

                maxManaFactor = 1;
                maxLifeFactor = 1;
                maxAttackFactor = 1;
                maxMagicalAttackFactor = 1;
                maxDefenseFactor = 1;
                maxMagicalDefenseFactor = 1;

                maxLife = 240;
                maxMana = 60;
                maxDefense = 65;
                maxMagicalDefense = 50;
                maxAttack = 45;
                maxMagicalAttack = 30;
                heal = 3;
                break;
        
            case 1:
                gp.keyH.characterName = "Mage";

                spellName = new String[]{"Fireball", "Raging Inferno", "Frost Nova"};
                spellRequirement = new int[]{10, 13, 18};
                spellCooldown = new int[]{2, 5, 6};
                spellMana = new int[]{10, 18, 20};
                spellMagicalAttack = new int[]{15, 20, 0}; // Fill with random values
                spellMagicalDef = new int[]{5, 0, 15}; // Fill with random values
                spellDescription = new String[]{
                    "Hurls a fiery projectile at the target, \n" + //
                            "dealing moderate fire damage.",
                    "Engulfs the target in a raging inferno, \n" + //
                            "dealing continuous fire damage for 3 rounds.",
                    "The Mage releases a burst of frost, \n" + //
                            "freezing nearby enemies in place for 2 rounds."
                };

                maxManaFactor = 1;
                maxLifeFactor = 1;
                maxAttackFactor = 3;
                maxMagicalAttackFactor = 1;
                maxDefenseFactor = 1;
                maxMagicalDefenseFactor = 1;

                maxLife = 200;
                maxMana = 150;
                maxDefense = 30;
                maxMagicalDefense = 100;
                maxAttack = 20;
                maxMagicalAttack = 30;
                heal = 5;
                break;
        
            case 2:
                gp.keyH.characterName = "Paladin";

                spellName = new String[]{"Holy Smite", "Divine Shield", "Ice Barrier"};
                spellRequirement = new int[]{7, 15, 21};
                spellCooldown = new int[]{3, 6, 6};
                spellMana = new int[]{10, 18, 15};
                spellMagicalAttack = new int[]{20, 0, 0}; // Fill with random values
                spellMagicalDef = new int[]{10, 0, 25}; // Fill with random values
                spellDescription = new String[]{
                    "Smashes the target with divine light, dealing damage and healing \n" + //
                            "the Paladin for a portion of the damage dealt.",
                    "Creates a protective barrier around the Paladin, \n" + //
                            "rendering them immune to damage for 2 rounds.",
                    "Conjures a protective ice barrier, reducing incoming \n" + //
                            "damage and freezing attackers for 2 rounds."
                };

                maxManaFactor = 1;
                maxLifeFactor = 1;
                maxAttackFactor = 2;
                maxMagicalAttackFactor = 2;
                maxDefenseFactor = 1;
                maxMagicalDefenseFactor = 1;

                maxLife = 350;
                maxMana = 100;
                maxDefense = 70;
                maxMagicalDefense = 60;
                maxAttack = 80;
                maxMagicalAttack = 60;
                heal = 3;
                break;
        
            case 3:
                gp.keyH.characterName = "Rogue";

                spellName = new String[]{"Backstab", "Poisonous Strike", "Shadowstep"};
                spellRequirement = new int[]{5, 14, 25};
                spellCooldown = new int[]{3, 4, 6};
                spellMana = new int[]{12, 15, 15};
                spellMagicalAttack = new int[]{0, 0, 0}; // Fill with random values
                spellMagicalDef = new int[]{0, 0, 0}; // Fill with random values
                spellDescription = new String[]{
                    "The Rogue sneaks behind the target, delivering a devastating backstab, \n" + //
                            "causing extra damage and stunning the enemy for 1 round.",
                    "Coats the weapon with a deadly poison, dealing damage over time and \n" + //
                            "reducing the target's defenses for 3 rounds.",
                    "The Rogue can evade the next spell or attack from the enemies."
                };

                maxManaFactor = 1;
                maxLifeFactor = 1;
                maxAttackFactor = 3;
                maxMagicalAttackFactor = 1;
                maxDefenseFactor = 2;
                maxMagicalDefenseFactor = 1;

                maxLife = 250;
                maxMana = 75;
                maxDefense = 60;
                maxMagicalDefense = 40;
                maxAttack = 50;
                maxMagicalAttack = 40;
                heal = 4;
                break;
        
            case 4:
                gp.keyH.characterName = "Warrior";

                spellName = new String[]{"Divine Wrath", "Furious Strike", "Shield Wall"};
                spellRequirement = new int[]{8, 10, 25};
                spellCooldown = new int[]{4, 4, 6};
                spellMana = new int[]{13, 15, 20};
                spellMagicalAttack = new int[]{10, 15, 25};
                spellMagicalDef = new int[]{10, 25, 25};
                spellDescription = new String[]{
                    "Calls upon divine wrath to smite the target, \n" + //
                            "dealing damage and dispelling buffs.",
                    "Unleashes a powerful attack, dealing heavy \n" + //
                            "damage to the target.",
                    "The Warrior creates an impenetrable barrier with their \n" + //
                            "shield, reducing incoming damage for 3 rounds."
                };

                maxManaFactor = 1;
                maxLifeFactor = 2;
                maxAttackFactor = 1;
                maxMagicalAttackFactor = 1;
                maxDefenseFactor = 2;
                maxMagicalDefenseFactor = 2;
                
                maxLife = 300;
                maxMana = 50;
                maxDefense = 80;
                maxMagicalDefense = 20;
                maxAttack = 70;
                maxMagicalAttack = 50;
                heal = 2;
                break;
            }

        
        
        
        // maxLife = 300;
        // maxAttack = 2;
        // maxMana = 1000;
        // maxMagicalAttack = 2;
        // maxDefense = 2;
        // maxMagicalDefense = 3;
        // heal = 10;

        
        life = maxLife;
        attack = maxAttack;
        mana = maxMana;
        magicalAttack = maxMagicalAttack;
        defense = maxDefense;
        magicalDefense = maxMagicalDefense;


        exp=1;

        
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

        //System.out.println(gp.keyH.characterName);
        //gp.keyH.characterName;

        up1 = setup("/res//player/" + gp.keyH.characterName + "_up1");
        up2 = setup("/res/player/" + gp.keyH.characterName + "_up2");
        down1 = setup("/res/player/" + gp.keyH.characterName + "_down1");
        down2 = setup("/res/player/" + gp.keyH.characterName + "_down2");
        left1 = setup("/res/player/" + gp.keyH.characterName + "_left1");
        left2 = setup("/res/player/" + gp.keyH.characterName + "_left2");
        right1 = setup("/res/player/" + gp.keyH.characterName + "_right1");
        right2 = setup("/res/player/" + gp.keyH.characterName + "_right2");

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
                gp.stopMusic();
                gp.playMusic(5);
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
            // Player's attack logic
            damageDealt = Math.max(random.nextInt(gp.player.attack) + 1, gp.player.attack/4);
            //damageDealt = gp.player.attack;
            gp.npc[i].life = Math.max(0, gp.npc[i].life - damageDealt);

            gp.ui.playerAttackDialogue = "You attacked the " + gp.npc[i].name + " with " + damageDealt + "!\n";

            damageDealt = 0;

            if (gp.npc[i].life <= 0) {
                // If not defeated, let the monster attack
                gp.ui.monsterAttackDialogue = "The " + gp.npc[i].name + " has been slain!\n";
            } 
            
        } else {
            gp.ui.gameOverStateNum = 1;
            gp.gameState = gp.gameOverState;

            //playerWin = false;.

            //music
            gp.stopMusic();
            gp.playSE(3);    
        
        }
    }

    public void playerSpellAttack(int i, int spellNo) {
        if (gp.player.life > 0) {
            
            Random random = new Random();
            // damageDealt = random.nextInt(gp.player.attack) + 1;

            damageDealt = gp.player.spellMagicalAttack[spellNo];
            // Player's attack logic
            damageDealt = gp.player.attack;
            gp.npc[i].life = Math.max(0, gp.npc[i].life - damageDealt);

            //gp.ui.playerAttackDialogue = "You attacked the " + gp.npc[i].name + " with " + damageDealt + "!";

            gp.ui.playerAttackDialogue = gp.player.spellDescription[spellNo] + "Damage: " + damageDealt;

            damageDealt = gp.player.spellMagicalDef[spellNo];

            if(spellNo == 1 && gp.keyH.characterName == "Paladin") {
                gp.player.life += gp.player.spellMagicalAttack[spellNo]/random.nextDouble(1);
                gp.player.life = Math.min(gp.player.maxLife, gp.player.life);
            }

            gp.player.spellCooldownOn[spellNo] = gp.player.spellCooldown[spellNo];

            if (gp.npc[i].life <= 0) {
                // If not defeated, let the monster attack
                gp.ui.monsterAttackDialogue = "The " + gp.npc[i].name + " has been slain!";
            } 
            
        } else {
            gp.ui.gameOverStateNum = 1;
            gp.gameState = gp.gameOverState;

            //playerWin = false;

            //music
            gp.stopMusic();
            gp.playSE(3);    

        }
    }

    public void playerDefend(int i) {
        if (gp.player.life > 0) {
            
            // Player's attack logic
            gp.ui.playerAttackDialogue = "You put " + gp.player.defense + " defense! \n";

            damageDealt1 = gp.player.defense;

        }   else {
            gp.ui.gameOverStateNum = 1;
            gp.gameState = gp.gameOverState;

            //playerWin = false;

            //music
            gp.stopMusic();
            gp.playSE(3);     

        }
    }

    public void playerHeal(int i) {
        if (gp.player.life > 0) {
            
            // Player's attack logic
            gp.player.life += gp.player.heal;
            gp.player.life = Math.min(gp.player.maxLife, gp.player.life);

            gp.ui.playerAttackDialogue = "You healed with " + gp.player.heal + "! Refreshing, right? \n";

        }   else {
            gp.ui.gameOverStateNum = 1;
            gp.gameState = gp.gameOverState;

            //playerWin = false;

            //music
            gp.stopMusic();
            gp.playSE(3);     

        }
    }


    public void playerRun(int i) {
        gp.ui.gameOverStateNum = 2;
        gp.gameState = gp.gameOverState;

        //playerWin = true;

        //music
        gp.stopMusic();
        gp.playMusic(2);        

        
        
    }

    public void monsterAttack(int i) {
        // Check if the monster is defeated
        if (gp.npc[i].life > 0) {
            // If not defeated, let the monster attack
            damageDealt = gp.npc[i].npcAttack(i);
            gp.player.life -= Math.max(0,damageDealt - damageDealt1);
            gp.player.life = Math.max(0,gp.player.life);
            gp.ui.monsterAttackDialogue = "The " + gp.npc[i].name + " attacked you with " + damageDealt + "! \n";
            damageDealt = 0;
            damageDealt1 = 0;

        } else {
            // Handle victory, gain experience, etc.
            gp.ui.playerAttackDialogue = "You defeated the " + gp.npc[i].name + " !";
            gp.ui.gameOverStateNum = 0;
            gp.gameState = gp.gameOverState;

            gp.ui.rewarded = false;

            //remove monster
            gp.npc[i].worldX = -10;
            gp.npc[i].worldX = -10;    
            
            //music
            gp.stopMusic();
            gp.playMusic(4);

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
