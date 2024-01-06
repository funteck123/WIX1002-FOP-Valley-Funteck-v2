package entity;

import main.GamePanel;

public class Monster_Witch extends Entity {
    public Monster_Witch(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        up1=setup("/res/monster/Witch_up1");
        up2=setup("/res/monster/Witch_up2");
        down1=setup("/res/monster/Witch_down1");
        down2=setup("/res/monster/Witch_down2");
        left1=setup("/res/monster/Witch_left1");
        left2=setup("/res/monster/Witch_left2");
        right1=setup("/res/monster/Witch_right1");
        right2=setup("/res/monster/Witch_right2");
     }
    
     public void setDialogue() {

        dialogues[0] = "You have encountered a witch.\n\n1. Talk\n2. Fight\n3. Run";
        dialogues[1] = "Magic is my forte, darling.";
        dialogues[2] = "Step closer, let me weave a spell that'll linger\non your lips.";
        
    }
    
    public void setAction() {
        super.setAction();    
    }

    public void speak() {
        super.speak();
    }

}

