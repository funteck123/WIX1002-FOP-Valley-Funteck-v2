package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import main.GamePanel;

public class SaveLoad {

    GamePanel gp;

    public SaveLoad(GamePanel gp) {
        this.gp = gp;
    }

    public void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));

            DataStorage ds = new DataStorage();

            // Player stats
            ds.playerLevel = gp.player.level;
            ds.playerExp = gp.player.exp;

            ds.playerLife = gp.player.life;
            ds.playerMana = gp.player.mana;
            ds.playerAttack = gp.player.attack;
            ds.playerMagicalAttack = gp.player.magicalAttack;
            ds.playerDefense = gp.player.defense;
            ds.playerMagicalDefense = gp.player.magicalDefense;

            // Player max stats
            ds.playerMaxLife = gp.player.maxLife;
            ds.playerMaxMana = gp.player.maxMana;
            ds.playerMaxAttack = gp.player.maxAttack;
            ds.playerMaxMagicalAttack = gp.player.maxMagicalAttack;
            ds.playerMaxDefense = gp.player.maxDefense;
            ds.playerMaxMagicalDefense = gp.player.maxMagicalDefense;

            // Player position
            ds.playerX = gp.player.worldX;
            ds.playerY = gp.player.worldY;

            //Character selection
            ds.characterSelection = gp.keyH.characterSelection;
            ds.characterName = gp.keyH.characterName;

            // Write the data to the file
            oos.writeObject(ds);
            oos.close(); // Close the ObjectOutputStream

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));

            DataStorage ds = (DataStorage) ois.readObject();

            // Player stats
            gp.player.level = ds.playerLevel;
            gp.player.exp = ds.playerExp;

            gp.player.life = ds.playerLife;
            gp.player.mana = ds.playerMana;
            gp.player.attack = ds.playerAttack;
            gp.player.magicalAttack = ds.playerMagicalAttack;
            gp.player.defense = ds.playerDefense;
            gp.player.magicalDefense = ds.playerMagicalDefense;

            // Player max stats
            gp.player.maxLife = ds.playerMaxLife;
            gp.player.maxMana = ds.playerMaxMana;
            gp.player.maxAttack = ds.playerMaxAttack;
            gp.player.maxMagicalAttack = ds.playerMaxMagicalAttack;
            gp.player.maxDefense = ds.playerMaxDefense;
            gp.player.maxMagicalDefense = ds.playerMaxMagicalDefense;

            // Player position
            gp.player.worldX = ds.playerX;
            gp.player.worldY = ds.playerY;

            //Character selection
            gp.keyH.characterSelection = ds.characterSelection;
            gp.keyH.characterName = ds.characterName;

            ois.close(); // Close the ObjectInputStream

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
