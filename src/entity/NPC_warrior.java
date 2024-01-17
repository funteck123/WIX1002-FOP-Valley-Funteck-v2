package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_warrior extends Entity {
    public NPC_warrior(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();

        solidArea.x=4;
        solidArea.y=16;
        solidArea.width=40;
        solidArea.height=32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        spellName = new String[]{"Divine Wrath", "Furious Strike", "Shield Wall"};
        spellRequirement = new int[]{8, 10, 25};
        spellCooldown = new int[]{4, 4, 6};
        spellMana = new int[]{13, 15, 20};
        spellMagicalAttack = new int[]{10, 15, 25};
        spellMagicalDef = new int[]{10, 25, 25};
        spellDescription = new String[]{
            "Calls upon divine wrath to smite the target, dealing damage and dispelling buffs.",
            "Unleashes a powerful attack, dealing heavy damage to the target.",
            "The Warrior creates an impenetrable barrier with their shield, reducing incoming damage for 3 rounds."
        };

        maxManaFactor = 1;
        maxLifeFactor = 1;
        maxAttackFactor = 1;
        maxMagicalAttackFactor = 1;
        maxDefenseFactor = 1;
        maxMagicalDefenseFactor = 1;
        
        maxLife = 300;
        maxMana = 50;
        maxDefense = 80;
        maxMagicalDefense = 20;
        maxAttack = 70;
        maxMagicalAttack = 50;
        heal = 2;
        description = "Goblins are small, pesky creatures that rely on sheer numbers to overpower their foes. They have no special abilities.";

        
        life = maxLife;
        attack = maxAttack;
        mana = maxMana;
        magicalAttack = maxMagicalAttack;
        defense = maxDefense;
        magicalDefense = maxMagicalDefense;

        
    }

    public void getImage() {
        up1=setup("/res/npc/Warrior_up1");
        up2=setup("/res/npc/Warrior_up2");
        down1=setup("/res/npc/Warrior_down1");
        down2=setup("/res/npc/Warrior_down2");
        left1=setup("/res/npc/Warrior_left1");
        left2=setup("/res/npc/Warrior_left2");
        right1=setup("/res/npc/Warrior_right1");
        right2=setup("/res/npc/Warrior_right2");
    }

    public void setDialogue() {

        dialogues[0] = "You have encountered a warrior. \n\n1. Talk\n2. Fight\n3. Run";
        dialogues[1] = "Sword's name: 'DeathBringer.'\nReady for a demo?";
        dialogues[2] = "I have a neat sword. \nWanna die?";
        
    }
    
    public void setAction() {

        actionLockCounter ++;

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

    public void speak() {
        super.speak();
    }

}

