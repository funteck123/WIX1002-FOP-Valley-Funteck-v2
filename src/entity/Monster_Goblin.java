package entity;

import main.GamePanel;

public class Monster_Goblin extends Entity {
    public Monster_Goblin(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
    }
    public void getImage() {
        up1=setup("/res/Monster/Goblin_up1");
        up2=setup("/res/Monster/Goblin_up2");
        down1=setup("/res/Monster/Goblin_down1");
        down2=setup("/res/Monster/Goblin_down2");
        left1=setup("/res/Monster/Goblin_left1");
        left2=setup("/res/Monster/Goblin_left2");
        right1=setup("/res/Monster/Goblin_right1");
        right2=setup("/res/Monster/Goblin_right2");
     }
    
}

