package entity;

import main.GamePanel;

public class NPC_warrior extends Entity {
    public NPC_warrior(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
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
    
}

