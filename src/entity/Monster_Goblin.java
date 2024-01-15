package entity;

import main.GamePanel;

public class Monster_Goblin extends Entity {
    public Monster_Goblin(GamePanel gp) {
        super(gp);

        name = "Goblin";

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();

        solidArea.x=4;
        solidArea.y=16;
        solidArea.width=40;
        solidArea.height=32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        maxLife = 11;
        life = maxLife;


        maxAttack = 10;
        maxMagicalAttack = 2;
        maxDefense = 5;
        maxMagicalDefense = 3;
        attack = maxAttack;
        magicalAttack = maxMagicalAttack;
        defense = maxDefense;
        magicalDefense = maxMagicalDefense;
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
    
    public void setDialogue() {

        dialogues[1] = "Sword's name: 'Banterbringer.'\nReady for a demo?";
        dialogues[0] = "You have encountered a warrior.\n\n1. Talk\n2. Fight\n3. Run";
        dialogues[2] = "I have neat sword.";
        
    }
    
    public void setAction() {
        super.setAction();    
    }

    public void speak() {
        super.speak();
    }

    // public void fight() {
    //     super.fight();
    // }

}