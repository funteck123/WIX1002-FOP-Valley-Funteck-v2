package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class spells {
    spell_ForArcher  archer = new spell_ForArcher();
    spell_ForRogue  rogue = new spell_ForRogue();
    spell_ForMage mage = new spell_ForMage();
    Spells_ForWarrior warrior = new Spells_ForWarrior();
   
    public class TextFileReader {
        public String[] name = new String[5];
        public String[] spellName = new String[12];
        public int[] requirement = new int[12];
        public int[] cooldown = new int[12];
        public int[] Mana = new int[12];
   

        private int currentIndex = 0;

      public void readTextFile(String filePath) {
    try {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        int index = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.startsWith("**")) {
           name[index] = line.substring(3, line.length() - 2); // Extract name from line
            } else if (line.startsWith(" \"")) {
                spellName[index] = line.substring(3, line.length() -1); // Extract name from line
            } 
            else if (line.contains(":")) {
                String[] parts = line.split(":");
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (name[index]){
                    case "Warrior":

                switch (key) {
                    case  "- Level Requirement":
                 warrior. requirement[index] = Integer.parseInt(value);
                        break;
                    case "- Cool Down":
                     warrior.   cooldown[index] = Integer.parseInt(value);
                        break;
                    case "  - Mana":
                    warrior.Mana[index] = Integer.parseInt(value);
                        break;
                 
                }break;
                case "Archer":
                switch (key) {
                    case  "- Level Requirement":
                 archer. requirement[index] = Integer.parseInt(value);
                        break;
                    case "- Cool Down":
                     archer.   cooldown[index] = Integer.parseInt(value);
                        break;
                    case "  - Mana":
                    archer.Mana[index] = Integer.parseInt(value);
                        break;}
                        case " Mage":
                        switch (key) {
                            case  "- Level Requirement":
                         mage. requirement[index] = Integer.parseInt(value);
                                break;
                            case "- Cool Down":
                             mage.   cooldown[index] = Integer.parseInt(value);
                                break;
                            case "  - Mana":
                            mage.Mana[index] = Integer.parseInt(value);
                                break;
                        }break;
                        case "Rogue":
                        switch (key) {
                            case  "- Level Requirement":
                         rogue. requirement[index] = Integer.parseInt(value);
                                break;
                            case "- Cool Down":
                             rogue.   cooldown[index] = Integer.parseInt(value);
                                break;
                            case "  - Mana":
                            rogue.Mana[index] = Integer.parseInt(value);
                                break;}break;
                             

                                        case "Paladin":
                                        switch (key) {
                                            case  "- Level Requirement":
                                         warrior. requirement[index] = Integer.parseInt(value);
                                                break;
                                            case "- Cool Down":
                                             warrior.   cooldown[index] = Integer.parseInt(value);
                                                break;
                                            case "  - Mana":
                                            warrior.Mana[index] = Integer.parseInt(value);
                                                break;}break;
                                        }
                                 
                         
                 
                
            } else if (line.isEmpty()) {
                // Store the accumulated description
              // Clear StringBuilder for next entry
                index++; // Move to the next index for the next entry
            }}

        }
        
        

       
        scanner.close();
       
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

       
        
    
}
      }}