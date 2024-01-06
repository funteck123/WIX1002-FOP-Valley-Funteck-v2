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

