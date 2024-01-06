package entity;

import main.GamePanel;

public class Monster_Skeleton extends Entity {
    public Monster_Skeleton(GamePanel gp) {
   

        super(gp);


        direction = "down";
        speed = 1;
        getImage();
    }
    public void getImage() {
        up1=setup("/res/Monster/Skeleton_up1");
        up2=setup("/res/Monster/Skeleton_up2");
        down1=setup("/res/Monster/Skeleton_down1");
        down2=setup("/res/Monster/Skeleton_down2");
        left1=setup("/res/Monster/Skeleton_left1");
        left2=setup("/res/Monster/Skeleton_left2");
        right1=setup("/res/Monster/Skeleton_right1");
        right2=setup("/res/Monster/Skeleton_right2");
     }
    
}

