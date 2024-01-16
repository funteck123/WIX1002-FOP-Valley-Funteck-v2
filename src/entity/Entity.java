package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

    /// badr change 

   

    public String[] nameCharacter = new String[5];
    public String[] spellName = new String[3];
    public String[] spellDescription = new String[3];
    public int[] spellRequirement = new int[3];
    public int[] spellCooldown = new int[3];
    public int[] spellMana = new int[3];
    int[] spellMagicalAttack = new int[3];
    int[] spellMagicalDef = new int[3];  










    GamePanel gp;
    public int worldX, worldY;
    // public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction = "down";
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;
    public String dialogues[] = new String[20];
    public int dialogueIndex = 0;
    // public ArrayList<String> spellName = new ArrayList<String>();
    // public ArrayList<String> spellMana = new ArrayList<String>();
    // public ArrayList<String> spellMagicalAtk = new ArrayList<String>();
    // public ArrayList<String> spellMagicalDef = new ArrayList<String>();
    // public ArrayList<String> spellCooldown = new ArrayList<String>();
    // public int monsterIndex = 999;
    public boolean monsterWin = true;
    public boolean playerWin = true;

    



    

    public BufferedImage image, image2, image3;
    public String name = "default";
    public boolean collision = false;

    // Character Status
    public int type;
    public int speed;
    public int maxLife;
    public int life;
    //public int level;
    public int strength;
    public int dexterity;
    public int maxMana;
    public int mana;
    public int heal;
    //public int attack;
    //public int defense;
    
    public int coin;
    public Entity currentWeapon;
    public Entity currentShield;

    public int maxAttack;
    public int maxMagicalAttack;
    public int maxDefense;
    public int maxMagicalDefense;
    public int attack;
    public int magicalAttack;
    public int defense;
    public int magicalDefense;
    public int expReward;
    public String description;
    public String asciiArt;

    public int level;
    public int exp;
    public int[] nextLevelExp = new int[100]; 

    public Entity(GamePanel gp) {
        this.gp = gp;

        this.spellName = new String[]{"Fireball", "Iceball", "Lightning"};
        this.spellDescription = new String[]{"Spell 1","Spell 2","Spell 3"};
        this.spellRequirement = new int[]{1, 5, 10};
        this.spellCooldown = new int[]{3, 5, 7};
        this.spellMana = new int[]{100, 500, 1000};
        this.spellMagicalAttack = new int[]{5, 10, 25};
        this.spellMagicalDef = new int[]{5, 10, 25};  

        this.maxLife = 300;
        this.maxMana = 50;
        this.maxDefense = 80;
        this.maxMagicalDefense = 20;
        this.maxAttack = 70;
        this.maxMagicalAttack = 50;
        this.heal = 2;

        
        this.life = maxLife;
        this.attack = maxAttack;
        this.mana = maxMana;
        this.magicalAttack = maxMagicalAttack;
        this.defense = maxDefense;
        this.magicalDefense = maxMagicalDefense;
        this.expReward = 150;

        this.description = "entity description";
        this.asciiArt = "\"\\\\****__              ____                                              \\r\\n" + //
                "\" + //\r\n" + //
                "                \"|    *****\\\\_      --/ *\\\\-__                                          \\r\\n" + //
                "\" + //\r\n" + //
                "                \"/_          (_    ./ ,/----'                                         \\r\\n" + //
                "\" + //\r\n" + //
                "                \"     \\\\__         (_./  /                                                \\r\\n" + //
                "\" + //\r\n" + //
                "                \"       \\\\__           \\\\___----^__                                       \\r\\n" + //
                "\" + //\r\n" + //
                "                \"          _/   _                  \\\\                                      \\r\\n" + //
                "\" + //\r\n" + //
                "                \"   |    _/  __/ )\\\\\\\"\\\\ _____         *\\\\                                    \\r\\n" + //
                "\" + //\r\n" + //
                "                \"   |\\\\__/   /    ^ ^       \\\\____      )                                   \\r\\n" + //
                "\" + //\r\n" + //
                "                \"    \\\\___--\\\"                    \\\\_____ \\r\\n" + //
                "\" + //\r\n" + //
                "                \"\"";


        this.exp = 0;
        
        for (int i = 0; i < nextLevelExp.length; i++) {
            if (i < 10) {
                this.nextLevelExp[i] = 25;
            } else {
                this.nextLevelExp[i] = 50;
            }
        }
        


    }

    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter > 120) {

            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "up";
            } else if (i > 25 && i <= 50) {
                direction = "down";
            } else if (i > 50 && i <= 75) {
                direction = "left";
            } else if (i > 75 && i <= 100) {
                direction = "right";
            }

            actionLockCounter = 0;

        }

    }

    public void setSpells() {
        spellName = new String[]{"Rapid Shot", "Trick Shot", "Smoke Bomb"};
        spellRequirement = new int[]{10, 15, 22};
        spellCooldown = new int[]{2, 6, 5};
        spellMana = new int[]{8, 17, 20};
        spellMagicalAttack = new int[]{0, 0, 0}; // Fill with random values
        spellMagicalDef = new int[]{0, 0, 0}; // Fill with random values
    }


    public void fight() {   

        //gp.ui.npcIndex = 2;

    }

    public void playerAttack() {

    }

    public void monsterAttack() {

    }

    public void speak() {

        if (dialogues[dialogueIndex] == null) {
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction) {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }

    }

    public int npcAttack(int i) {
        int damage = 0;
        Random random = new Random();
        int j = random.nextInt(gp.npc[i].attack) + 1;
        damage = j;
        return damage;
    }



    public void update() {

        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
        gp.cChecker.checkPlayer(this);

        // IF NO Collision
        if (collisionOn == false) {
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

        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }


    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
                && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
                && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

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

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }

    public BufferedImage setup(String imagePath) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

}
