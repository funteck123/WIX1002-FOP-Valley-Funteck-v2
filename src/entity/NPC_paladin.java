package entity;

import main.GamePanel;

public class NPC_paladin extends Entity {
    public NPC_paladin(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
    }

    public void getImage() {
        up1=setup("/res/npc/Paladin_up1");
        up2=setup("/res/npc/Paladin_up2");
        down1=setup("/res/npc/Paladin_down1");
        down2=setup("/res/npc/Paladin_down2");
        left1=setup("/res/npc/Paladin_left1");
        left2=setup("/res/npc/Paladin_left2");
        right1=setup("/res/npc/Paladin_right1");
        right2=setup("/res/npc/Paladin_right2");
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


