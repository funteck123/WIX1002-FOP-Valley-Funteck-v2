package entity;

import main.GamePanel;

public class Monster_Orc extends Entity {
    public Monster_Orc(GamePanel gp) { 
      super(gp);
      name="Orc";
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
      description = "Orcs are hulking, brutish creatures \nknown for their raw strength. They have no unique abilities.";
      asciiArt = 
      
      "             _.-;-._\n" +
      "            ;_.JL___;\n" +
      "            F\"-/\\_-7L\n" +
      "            | a/ e | \\\n" +
      "           ,L,c;,.='/;, \n" +
      "        _,-;;S:;:S;;:' '--._\n" +
      "       ;. \\;;s:::s;;: .'   /\\\n" +
      "      /  \\  ;::::;;  /    /  \\\n" +
      "     / ,  k ;S';;'S.'    j __,l\n" +
      "  ,---/| /  /S   /S '.   |'   ;\n" +
      " ,Ljjj |/|.' s .' s   \\  L    |\n" +
      " LL,_ ]( \\    /    '.  '.||   ;\n" +
      " ||\\ > /  ;-.'_.-.___\\.-'(|===\"\n" +
      " JJ,\" /   |_  [   ]     _]|   /\n" +
      "  LL\\/   ,' '--'-'-----'  \\  (\n" +
      "  ||     ;      |          |  >\n" +
      "  JJ     |      |\\         |,/\n" +
      "   LL    |      ||       ' |\n" +
      "   ||    |      ||       . |\n" +
      "   JJ    /_     ||       ;_|\n" +
      "    LL   L \"==='|i======='_|\n" +
      "    ||    i----' '-------';\n" +
      "    JJ    ';-----.------,-'\n" +
      "     LL     L_.__J,'---;'\n" +
      "     ||      |   ,|    (\n" +
      "     JJ     .'=  (|  ,_|\n" +
      "      LL   /    .'L_    \\\n" +
      "        ||   '---'    '___>\n";

      
      
      life = maxLife;
      attack = maxAttack;
      mana = maxMana;
      magicalAttack = maxMagicalAttack;
      defense = maxDefense;
      magicalDefense = maxMagicalDefense;

      
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

}
