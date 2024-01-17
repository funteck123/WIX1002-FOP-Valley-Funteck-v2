package entity;

import main.GamePanel;

public class NPC_paladin extends Entity {
    public NPC_paladin(GamePanel gp) {
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

        spellName = new String[]{"Holy Smite", "Divine Shield", "Ice Barrier"};
        spellRequirement = new int[]{7, 15, 21};
        spellCooldown = new int[]{3, 6, 6};
        spellMana = new int[]{10, 18, 15};
        spellMagicalAttack = new int[]{20, 0, 0}; // Fill with random values
        spellMagicalDef = new int[]{10, 0, 25}; // Fill with random values
        spellDescription = new String[]{
            "Smashes the target with divine light, dealing damage and healing the Paladin for a portion of the damage dealt.",
            "Creates a protective barrier around the Paladin, rendering them immune to damage for 2 rounds.",
            "Conjures a protective ice barrier, reducing incoming damage and freezing attackers for 2 rounds."
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

        dialogues[0] = "You have encountered a Paladin.\n\n1. Talk\n2. Fight\n3. Run";
        dialogues[1] = "Chivalry is dead, but I'll settle for a kiss.";
        dialogues[2] = "Step closer, let me weave a spell that'll linger\non your lips.";
        
    }
    
    public void setAction() {
        super.setAction();    
    }

    public void speak() {
        super.speak();
    }
    

}


