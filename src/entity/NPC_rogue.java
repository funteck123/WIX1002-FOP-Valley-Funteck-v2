package entity;

import main.GamePanel;

public class NPC_rogue extends Entity {
    public NPC_rogue(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 2;
        getImage();
        setDialogue();

        solidArea.x = 4;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        spellName = new String[]{"Backstab", "Poisonous Strike", "Shadowstep"};
        spellRequirement = new int[]{5, 14, 25};
        spellCooldown = new int[]{3, 4, 6};
        spellMana = new int[]{12, 15, 15};
        spellMagicalAttack = new int[]{0, 0, 0}; // Fill with random values
        spellMagicalDef = new int[]{0, 0, 0}; // Fill with random values
        spellDescription = new String[]{
            "The Rogue sneaks behind the target, delivering a devastating backstab, causing extra damage and stunning the enemy for 1 round.",
            "Coats the weapon with a deadly poison, dealing damage over time and reducing the target's defenses for 3 rounds.",
            "The Rogue can evade the next spell or attack from the enemies."
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

        
        // Set other properties specific to the rogue
    }

    public void getImage() {
        up1 = setup("/res/npc/Rogue_up1");
        up2 = setup("/res/npc/Rogue_up2");
        down1 = setup("/res/npc/Rogue_down1");
        down2 = setup("/res/npc/Rogue_down2");
        left1 = setup("/res/npc/Rogue_left1");
        left2 = setup("/res/npc/Rogue_left2");
        right1 = setup("/res/npc/Rogue_right1");
        right2 = setup("/res/npc/Rogue_right2");
    }

    public void setDialogue() {
        dialogues[0] = "You have encountered a rogue. \n\n1. Talk\n2. Fight\n3. Run";
        dialogues[1] = "Dagger's name: 'Silent Shadow.'\nReady for a demo?";
        dialogues[2] = "I have a sharp dagger. \nWanna test it?";
    }

    // ... (additional methods specific to the rogue can be added if needed)

    @Override
    public void setAction() {
        // Modify or override the action for the rogue if needed
        super.setAction();
    }

    @Override
    public void speak() {
        // Modify or override the speak method for the rogue if needed
        super.speak();
    }
}
