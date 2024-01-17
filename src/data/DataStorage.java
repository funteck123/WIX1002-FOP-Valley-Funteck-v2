package data;

import java.io.Serializable;

public class DataStorage implements Serializable {
    
    // Player stats
    public int playerLevel;
    public int playerExp;

    public int playerLife;
    public int playerMana;
    public int playerAttack;
    public int playerMagicalAttack;
    public int playerDefense;
    public int playerMagicalDefense;

    // Player max stats
    public int playerMaxLife;
    public int playerMaxMana;
    public int playerMaxAttack;
    public int playerMaxMagicalAttack;
    public int playerMaxDefense;
    public int playerMaxMagicalDefense;

    // Player position
    public int playerX;
    public int playerY;

    //Character selection
    public int characterSelection;
    public String characterName;


}
