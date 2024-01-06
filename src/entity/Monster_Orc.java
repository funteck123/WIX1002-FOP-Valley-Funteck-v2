package entity;

import main.GamePanel;

public class Monster_Orc extends Entity {
    public Monster_Orc(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
    }
    public void getImage() {
        up1=setup("/res/Monster/Orc_up1");
        up2=setup("/res/Monster/Orc_up2");
        down1=setup("/res/Monster/Orc_down1");
        down2=setup("/res/Monster/Orc_down2");
        left1=setup("/res/Monster/Orc_left1");
        left2=setup("/res/Monster/Orc_left2");
        right1=setup("/res/Monster/Orc_right1");
        right2=setup("/res/Monster/Orc_right2");
     }
    
}

