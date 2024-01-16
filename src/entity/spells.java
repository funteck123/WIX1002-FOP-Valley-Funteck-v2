package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import main.GamePanel;

public class spells {
    private GamePanel gp;
    private NPC_archer archer = new NPC_archer(gp);
    private NPC_rogue rogue = new NPC_rogue(gp);
    private NPC_mage mage = new NPC_mage(gp);
    private NPC_warrior warrior = new NPC_warrior(gp);
    private NPC_paladin paladin = new NPC_paladin(gp);

    //public class TextFileReader {
    public String[] name = new String[5];
    // public String[] spellName = new String[15];
    // public int[] spellRequirement = new int[15];
    // public int[] spellCooldown = new int[15];
    // public int[] spellMana = new int[15];

        public void readSpellFile(String filePath) {
            try {
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);

                int index = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.startsWith("**")) {
                        name[index] = line.substring(3, line.length() - 2); // Extract name from line
                    } else if (line.startsWith(" \"")) {
                        //warrior.spellName[index] = line.substring(3, line.length() - 1); // Extract name from line
                    } else if (line.contains(":")) {
                        String[] parts = line.split(":");
                        String key = parts[0].trim();
                        String value = parts[1].trim();
                        switch (name[index]) {
                            case "Warrior":
                                switch (key) {
                                    case "- Level Requirement":
                                        warrior.spellRequirement[index] = Integer.parseInt(value);
                                        break;
                                    case "- Cool Down":
                                        warrior.spellCooldown[index] = Integer.parseInt(value);
                                        break;
                                    case "  - Mana":
                                        warrior.spellMana[index] = Integer.parseInt(value);
                                        break;
                                }
                                break;
                            case "Archer":
                                switch (key) {
                                    case "- Level Requirement":
                                        archer.spellRequirement[index] = Integer.parseInt(value);
                                        break;
                                    case "- Cool Down":
                                        archer.spellCooldown[index] = Integer.parseInt(value);
                                        break;
                                    case "  - Mana":
                                        archer.spellMana[index] = Integer.parseInt(value);
                                        break;
                                }
                                break;
                            case "Mage":
                                switch (key) {
                                    case "- Level Requirement":
                                        mage.spellRequirement[index] = Integer.parseInt(value);
                                        break;
                                    case "- Cool Down":
                                        mage.spellCooldown[index] = Integer.parseInt(value);
                                        break;
                                    case "  - Mana":
                                        mage.spellMana[index] = Integer.parseInt(value);
                                        break;
                                }
                                break;
                            case "Rogue":
                                switch (key) {
                                    case "- Level Requirement":
                                        rogue.spellRequirement[index] = Integer.parseInt(value);
                                        break;
                                    case "- Cool Down":
                                        rogue.spellCooldown[index] = Integer.parseInt(value);
                                        break;
                                    case "  - Mana":
                                        rogue.spellMana[index] = Integer.parseInt(value);
                                        break;
                                }
                                break;
                            case "Paladin":
                                switch (key) {
                                    case "- Level Requirement":
                                        paladin.spellRequirement[index] = Integer.parseInt(value);
                                        break;
                                    case "- Cool Down":
                                        paladin.spellCooldown[index] = Integer.parseInt(value);
                                        break;
                                    case "  - Mana":
                                        paladin.spellMana[index] = Integer.parseInt(value);
                                        break;
                                }
                                break;
                        }
                    } else if (line.isEmpty()) {
                        index++; // Move to the next index for the next entry
                    }
                }

                scanner.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }   
        }
    //}
}
