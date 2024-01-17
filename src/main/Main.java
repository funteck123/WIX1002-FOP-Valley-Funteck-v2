package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        String holder;
        String[] nameList = new String[2];
        String[] passwordList = new String[2];
        int choice;

        readCredentials(nameList, passwordList); // Read credentials from file

        boolean test = true;
        Scanner scanner = new Scanner(System.in);

        // Cool ASCII art logo
        System.out.println("\r\n" + //
                "  _____             __                 __    " + //
                "\r\n" + //
                "_/ ____\\_ __  _____/  |_  ____   ____ |  | __" + //
                "\r\n" + //
                "\\   __\\  |  \\/    \\   __\\/ __ \\_/ ___\\|  |/ /" + //
                "\r\n" + //
                " |  | |  |  /   |  \\  | \\  ___/\\  \\___|    < " + //
                "\r\n" + //
                " |__| |____/|___|  /__|  \\___  >\\___  >__|_ \\" + //
                "\r\n" + //
                "                 \\/          \\/     \\/     \\/" + //
                "\r\n" + //
                "\r\n" + //
                "");

        System.out.println("\nWelcome to Funteck FOP Valley Game - Login Page!");

        while (test) {
            choice = 2;
            while (choice !=0 && choice !=1) {
            System.out.println("\n0: Login\n1: Sign up [user:funteck:pass:fsktm]");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            }

            System.out.println("Enter username: ");
            holder = scanner.nextLine();
            nameList[1] = holder;

            System.out.println("Enter password: ");
            holder = scanner.nextLine();
            passwordList[1] = holder;

            if (choice == 1) {
                //if (nameList[1].equals("") && passwordList[1].equals("")) {
                    //System.exit(0);
                //} else {       
                    nameList[0] = nameList[1];
                    passwordList[0] = passwordList[1];
                    test = false;
                //}

            } else if (choice == 0) {
                if (nameList[0].equals(nameList[1]) && passwordList[0].equals(passwordList[1])) {
                    test = false;
                    break;
                } else if (nameList[1].equals("") && passwordList[1].equals("")) {
                    System.exit(0);
                } else {
                    System.out.println("Incorrect credentials. Please try again. Leave blank to exit.\n");
                }
            } else {
                System.exit(0);
            }


        }

        // Code for the game window remains unchanged
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("FOP Valley Funteck");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();

        scanner.close();
    }

    private static void readCredentials(String[] nameList, String[] passwordList) {
        try {
            Scanner fileScanner = new Scanner(new File("credentials.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(":");
                nameList[0] = parts[0];
                passwordList[0] = parts[1];
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
         }
    }
}