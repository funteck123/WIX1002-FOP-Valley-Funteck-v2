package entity;

import main.GamePanel;

public class NPC_warrior extends Entity {
    public NPC_warrior(GamePanel gp, int x, int y) {
        super(gp);
        direction = "down";
        speed = 1;
        getImage();
    }
    public void getImage() {
        up1=setup("/res/NPC/Warrior_up1");
        up2=setup("/res/NPC/Warrior_up2");
        down1=setup("/res/NPC/Warrior_down1");
        down2=setup("/res/NPC/Warrior_down2");
        left1=setup("/res/NPC/Warrior_left1");
        left2=setup("/res/NPC/Warrior_left2");
        right1=setup("/res/NPC/Warrior_right1");
        right2=setup("/res/NPC/Warrior_right2");
       
 
     }
    
}

