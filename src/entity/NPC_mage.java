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

        maxLife = 8;
        life = maxLife;

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
