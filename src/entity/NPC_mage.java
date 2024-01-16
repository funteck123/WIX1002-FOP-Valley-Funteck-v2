package entity;

import main.GamePanel;

public class NPC_mage extends Entity {
    public NPC_mage(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();

        solidArea.x = 4;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        spellName = new String[]{"Fireball", "Raging Inferno", "Frost Nova"};
        spellRequirement = new int[]{10, 13, 18};
        spellCooldown = new int[]{2, 5, 6};
        spellMana = new int[]{10, 18, 20};
        spellMagicalAttack = new int[]{15, 20, 0}; // Fill with random values
        spellMagicalDef = new int[]{5, 0, 15}; // Fill with random values
        spellDescription = new String[]{
            "Hurls a fiery projectile at the target, dealing moderate fire damage.",
            "Engulfs the target in a raging inferno, dealing continuous fire damage for 3 rounds.",
            "The Mage releases a burst of frost, freezing nearby enemies in place for 2 rounds."
        };

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

        
        // Set other properties specific to the mage
    }

    public void getImage() {
        up1 = setup("/res/npc/Mage_up1");
        up2 = setup("/res/npc/Mage_up2");
        down1 = setup("/res/npc/Mage_down1");
        down2 = setup("/res/npc/Mage_down2");
        left1 = setup("/res/npc/Mage_left1");
        left2 = setup("/res/npc/Mage_left2");
        right1 = setup("/res/npc/Mage_right1");
        right2 = setup("/res/npc/Mage_right2");
    }

    public void setDialogue() {
        dialogues[0] = "You have encountered a mage. \n\n1. Talk\n2. Fight\n3. Run";
        dialogues[1] = "Staff's name: 'Arcane Wand.'\nReady for a magic show?";
        dialogues[2] = "I wield powerful spells. \nCare for a demonstration?";
    }

    // ... (additional methods specific to the mage can be added if needed)

    @Override
    public void setAction() {
        // Modify or override the action for the mage if needed
        super.setAction();
    }

    @Override
    public void speak() {
        // Modify or override the speak method for the mage if needed
        super.speak();
    }
}
