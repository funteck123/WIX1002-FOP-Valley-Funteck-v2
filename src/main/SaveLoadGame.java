package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import entity.Player;

public class SaveLoadGame {

    public static void savePlayer(String fileName, Player player) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(player);
            System.out.println("Player saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player loadPlayer(String fileName) {
        Player player = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            player = (Player) ois.readObject();
            System.out.println("Player loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return player;
    }

    public static void savePlayerData(String fileName, Player player) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Health: " + player.life);
            writer.newLine();
            writer.write("Mana: " + player.mana);
            writer.newLine();
            // Save other player data as needed
            // ...

            System.out.println("Player data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadPlayerData(String fileName, Player player) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Health:")) {
                    int health = Integer.parseInt(line.substring("Health: ".length()).trim());
                    player.life = health;
                } else if (line.startsWith("Mana:")) {
                    int mana = Integer.parseInt(line.substring("Mana: ".length()).trim());
                    player.mana = mana;
                }
                // Parse and update other player data as needed
                // ...
            }
            System.out.println("Player data loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveMonstersKilled(String fileName, List<String> monstersKilled) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String monster : monstersKilled) {
                writer.write(monster);
                writer.newLine();
            }

            System.out.println("Monsters killed data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadMonstersKilled(String fileName) {
        List<String> monstersKilled = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                monstersKilled.add(line);
            }
            System.out.println("Monsters killed data loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return monstersKilled;
    }
}
