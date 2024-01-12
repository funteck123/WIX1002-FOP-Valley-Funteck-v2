package Monster;

import entity.Entity;
import main.GamePanel;
public class Monster{
public class Monster_Goblin extends Entity {
    public Monster_Goblin(GamePanel gp) {
        super(gp);
            String name="Goblin";
     maxLife=4;
     life=maxLife;
     solidArea.x=3;
     solidArea.y=18;
     solidArea.width=42;
     solidArea.height=30;
     solidAreaDefaultX=solidArea.x;
     solidAreaDefaultY=solidArea.y;
       

        direction = "down";
        speed = 1;
        getImage();
        // setDialogue();
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
    
 /*    public void setDialogue() {

            dialogues[1] = "Sword's name: 'Banterbringer.'\nReady for a demo?";
            dialogues[0] = "You have encountered a warrior.\n\n1. Talk\n2. Fight\n3. Run";
            dialogues[2] = "I have neat sword.";
            
        }*/
        
        public void setAction() {
            super.setAction();    
        }

        public void speak() {
            super.speak();
    }

}

public class Monster_Harpy extends Entity {
    public Monster_Harpy(GamePanel gp) {
        super(gp);
        String name="Harpy";
        maxLife=4;
        life=maxLife;
     solidArea.x=3;
     solidArea.y=10;
     solidArea.width=42;
     solidArea.height=30;
     solidAreaDefaultX=solidArea.x;
     solidAreaDefaultY=solidArea.y;
        direction = "down";
        speed = 1;
        getImage();
        // setDialogue();
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

    // public void setDialogue() {

    //     dialogues[0] = "Sword's name: 'Banterbringer.'\nReady for a demo?";
    //     dialogues[1] = "You have encountered a warrior.\n\n1. Talk\n2. Fight\n3. Run";
    //     dialogues[2] = "I have neat sword.";
        
    // }
    
    public void setAction() {
        super.setAction();    
    }

    public void speak() {
        super.speak();
    }

}

public class Monster_Orc extends Entity {
    public Monster_Orc(GamePanel gp) { 
        super(gp);
     String   name="Orc";
     maxLife=4;
     life=maxLife;
     solidArea.x=3;
     solidArea.y=10;
     solidArea.width=42;
     solidArea.height=30;
     solidAreaDefaultX=solidArea.x;
     solidAreaDefaultY=solidArea.y;
        direction = "down";
        speed = 1;
        getImage();
      //  setDialogue();
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
    

   // public void setDialogue() {

      //  dialogues[1] = "Sword's name: 'Banterbringer.'\nReady for a demo?";
    //    dialogues[0] = "You have encountered a warrior.\n\n1. Talk\n2. Fight\n3. Run";
    //    dialogues[2] = "I have neat sword.";
        
  //  }
    
    public void setAction() {

        super.setAction();
     

        
    }

   

    public void speak() {
        super.speak();
    }

}




public class Monster_Skeleton extends Entity {
    public Monster_Skeleton(GamePanel gp) {
        super(gp);
        String   name="Skeleton";
        maxLife=4;
        life=maxLife;
     solidArea.x=3;
     solidArea.y=10;
     solidArea.width=42;
     solidArea.height=30;
     solidAreaDefaultX=solidArea.x;
     solidAreaDefaultY=solidArea.y;

        direction = "down";
        speed = 1;
        getImage();
        // setDialogue();
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
    

    // public void setDialogue() {

    //     dialogues[1] = "Sword's name: 'Banterbringer.'\nReady for a demo?";
    //     dialogues[0] = "You have encountered a warrior.\n\n1. Talk\n2. Fight\n3. Run";
    //     dialogues[2] = "I have neat sword.";
        
    // }
    
    public void setAction() {
        super.setAction();    
    }

    public void speak() {
        super.speak();
    }

}

public class Monster_Witch extends Entity {
    public Monster_Witch(GamePanel gp) {
        super(gp);
        String name="Witch";
        maxLife=4;
        life=maxLife;
     solidArea.x=3;
     solidArea.y=10;
     solidArea.width=42;
     solidArea.height=30;
     solidAreaDefaultX=solidArea.x;
     solidAreaDefaultY=solidArea.y;

        direction = "down";
        speed = 1;
        getImage();
       /// setDialogue();
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
    
    //  public void setDialogue() {

    //     dialogues[0] = "You have encountered a witch.\n\n1. Talk\n2. Fight\n3. Run";
    //     dialogues[1] = "Magic is my forte, darling.";
    //     dialogues[2] = "Step closer, let me weave a spell that'll linger\non your lips.";
        
    // }
    
    public void setAction() {
        super.setAction();    
    }

    public void speak() {
        super.speak();
    }

}
}




