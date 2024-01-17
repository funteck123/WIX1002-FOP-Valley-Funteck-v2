package entity;

import main.GamePanel;

public class Monster_Harpy extends Entity {
    public Monster_Harpy(GamePanel gp) {
        super(gp);
        name="Harpy";
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
        heal = 2;
        description = "Harpies are agile and cunning. They possess two abilities: \"Talon Strike,\" a \nphysical attack, and \"Wind Gust,\" a magical attack that can disrupt opponents.";
        asciiArt = 
        "   ,                                      ,\n" +
        "        |\\                                      /|\n" +
        "     ,   \\'._ ,                           ,  _.'/   ,\n" +
        "     |\\  {'. '-`\\,      ,-._**_.-,      ,/`-' .'}  /|\n" +
        "      \\`'-'-.  '.`\\      \\*____*/      /`.'  .-'-'`/\n" +
        "    ,'-'-._  '.  ) )     /`    `\\     ( (  .'  _.-'-',\n" +
        "    |\\'- _ '.   , /     /  /\"\"\\  \\     \\ ,  .'  _ -'/|\n" +
        "     \\'-.   .  ; (      \\_|^  ^|_/      ) ;   .  .-'/\n" +
        "      `'--, . ;  {`-.       \\__/      .-'}  ; . ,--'`\n" +
        "      '--`_. ;  { ^  \\    _|  |_    /  ^ }  ; ._`--'\n" +
        "      `,_.--  ;  { ^  `-'`      `'-`  ^ }  ;  --._,`\n" +
        "        ,_.-    ; {^                ^} ;    -._,\n" +
        "         ,_.-`), /\\{^,/\\         //\\,^}/\\ ,(`-._,\n" +
        "           _.'.-` /.'   \\        /   `.\\ `-.'_.\n" +
        "          `  _.' `       \\      /       ` '._   `\n" +
        "                        .-'.  .'-.\n" +
        "                      .'    `` ^  '.\n" +
        "                     /  ^ ^   ^  ^  \\\n" +
        "                     | ^    ^   ^   |\n" +
        "                    /^   ^/    \\  ^  \\\n" +
        "                    \\,_^_/    ^ \\_,^./\n" +
        "                     /=/  \\^   /  \\=\\\n" +
        "                 __ /=/_   | ^|   _\\=\\ __\n" +
        "               <(=,'=(==,) |  | (,==)=',=)>\n" +
        "                 /_/|_\\    /  \\    /_|_\\ \\\n" +
        "                 `V (=|  .'    '.  |=) V`\n" +
        "                     V  / _/  \\_ \\  V\n" +
        "                       `\"` \\  / `\"`\n" +
        "                            \\(\n";

        
        life = maxLife;
        attack = maxAttack;
        mana = maxMana;
        magicalAttack = maxMagicalAttack;
        defense = maxDefense;
        magicalDefense = maxMagicalDefense;

        
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

    public void setDialogue() {

        dialogues[0] = "Sword's name: 'Banterbringer.'\nReady for a demo?";
        dialogues[1] = "You have encountered a warrior.\n\n1. Talk\n2. Fight\n3. Run";
        dialogues[2] = "I have neat sword.";
        
    }
    
    public void setAction() {
        super.setAction();    
    }

    public void speak() {
        super.speak();
    }

}