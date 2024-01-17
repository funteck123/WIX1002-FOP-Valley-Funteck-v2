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

        maxLife = 40;
        maxMana = 0;
        maxDefense = 5;
        maxMagicalDefense = 2;
        maxAttack = 10;
        maxMagicalAttack = 0;
        heal = 2;
        description = "Goblins are small, pesky creatures that rely on sheer numbers to \noverpower their foes. They have no special abilities.";
        asciiArt ="             ,\r\n" + //
                "             /(.-\"\"-.)\\\r\n" + //
                "        |\\  \\/      \\/  /|\r\n" + //
                "        | \\ / =.  .=  \\ / |\r\n" + //
                "        \\( \\   o\\/o   / )/\r\n" + //
                "         \\_,  '-/  \\-' ,_/\r\n" + //
                "           /    \\__/   \\\r\n" + //
                "           \\ \\__/\\__/ /\r\n" + //
                "      _ __\\ \\|--|/ /___\r\n" + //
                "        /`    \\      /    `\\\r\n" + //
                "       /       '----'       \\\r\n" + //
                "";

        
        life = maxLife;
        attack = maxAttack;
        mana = maxMana;
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