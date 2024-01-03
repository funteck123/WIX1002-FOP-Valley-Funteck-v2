package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.security.Key;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels


    // FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();       
    Thread gameThread;
    Player player = new Player(this, keyH);

    //Player's position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // @Override
    // public void run() {
        
    //     double drawInternal = 1000000000 / FPS;
    //     double nextDrawTime = System.nanoTime() + drawInternal;

    //     while(gameThread != null) {
    //     //System.out.println("loop is running");
        
    //     // long currentTIme = System.nanoTime();
    //     //System.out.println(currentTIme);

    //     // 1 UPDATE: updat einfo such character position
    //     update();

    //     // 2 DRAW: draw the screen with the updated info
    //     repaint();
    //     try {
    //         double remainingTime = nextDrawTime - System.nanoTime();
    //         remainingTime = remainingTime / 1000000;

    //         if(remainingTime < 0) {
    //             remainingTime = 0;
    //         }

    //         Thread.sleep((long) remainingTime);

    //         nextDrawTime += drawInternal;


    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
        
    // }
    // }

     @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTIme;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {

            currentTIme = System.nanoTime();
            delta += (currentTIme - lastTime) / drawInterval;
            timer += (currentTIme - lastTime);
            lastTime = currentTIme;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
        
    }

    public void update() {
        
        player.update();

    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; //type casting

        player.draw(g2);
        
        g2.dispose();

    }

}
