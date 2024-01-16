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

        maxLife = 8;
        life = maxLife;

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
