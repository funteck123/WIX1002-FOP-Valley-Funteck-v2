package entity;

import main.GamePanel;

public class Monster_Witch extends Entity {
    public Monster_Witch(GamePanel gp) {
        super(gp);
        name="Witch";
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
        setDialogue();

        maxLife = 300;
        maxMana = 50;
        maxDefense = 80;
        maxMagicalDefense = 20;
        maxAttack = 70;
        maxMagicalAttack = 50;
        description = "Witches possess magical abilities, including the power to cast spells. \nTheir main ability is to cast \"Fireball,\" a potent fire-based magical attack.";
        asciiArt = " -o..    , ' .  .\n" +
        "    ~    `\n" +
        "           _.     zz\n" +
        "      .__/|_. z z          z\n" +
        "        -\")\\                      z\n" +
        "    __ //  )\n" +
        "      ~~/  \\-=,,._\n" +
        "        ~;;~   `'~`    -.__        \n" +
        "                            ~ ~ ~  __";
        
        life = maxLife;
        attack = maxAttack;
        mana = maxMana;
        magicalAttack = maxMagicalAttack;
        defense = maxDefense;
        magicalDefense = maxMagicalDefense;

        
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
    
     public void setDialogue() {

        dialogues[0] = "You have encountered a witch.\n\n1. Talk\n2. Fight\n3. Run";
        dialogues[1] = "Magic is my forte, darling.";
        dialogues[2] = "Step closer, let me weave a spell that'll linger\non your lips.";
        
    }
    
    public void setAction() {
        super.setAction();    
    }

    public void speak() {
        super.speak();
    }

}





