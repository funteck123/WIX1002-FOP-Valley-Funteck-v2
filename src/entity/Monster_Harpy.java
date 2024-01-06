package entity;

import main.GamePanel;

public class Monster_Harpy extends Entity {
    public Monster_Harpy(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        up1=setup("/res/Monster/Harpy_up1");
        up2=setup("/res/Monster/Harpy_up2");
        down1=setup("/res/Monster/Harpy_down1");
        down2=setup("/res/Monster/Harpy_down2");
        left1=setup("/res/Monster/Harpy_left1");
        left2=setup("/res/Monster/Harpy_left2");
        right1=setup("/res/Monster/Harpy_right1");
        right2=setup("/res/Monster/Harpy_right2");
    }

    public void setDialogue() {

        dialogues[0] = "Sword's name: 'Banterbringer.'\nReady for a demo?";
        dialogues[1] = "You have encountered a warrior.\n\n1. Talk\n2. Fight\n3. Run";
        dialogues[2] = "I have neat sword.";
        
    }
    
    public void setAction() {
        super.setAction();    
    }

    public void speak() {
        super.speak();
    }

}

