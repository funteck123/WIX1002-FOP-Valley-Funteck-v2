package entity;

import main.GamePanel;

public class NPC_archer extends Entity {
    public NPC_archer(GamePanel gp) {
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

        // Set other properties specific to the archer
    }

    public void getImage() {
        up1 = setup("/res/npc/Archer_up1");
        up2 = setup("/res/npc/Archer_up2");
        down1 = setup("/res/npc/Archer_down1");
        down2 = setup("/res/npc/Archer_down2");
        left1 = setup("/res/npc/Archer_left1");
        left2 = setup("/res/npc/Archer_left2");
        right1 = setup("/res/npc/Archer_right1");
        right2 = setup("/res/npc/Archer_right2");
    }

    public void setDialogue() {
        dialogues[0] = "You have encountered an archer. \n\n1. Talk\n2. Fight\n3. Run";
        dialogues[1] = "Bow's name: 'Swiftwind.'\nReady for an arrow storm?";
        dialogues[2] = "My arrows fly true. \nDodge if you can!";
    }

    // ... (additional methods specific to the archer can be added if needed)

    @Override
    public void setAction() {
        // Modify or override the action for the archer if needed
        super.setAction();
    }

    @Override
    public void speak() {
        // Modify or override the speak method for the archer if needed
        super.speak();
    }
}
