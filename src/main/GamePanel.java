package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.security.Key;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
//import tile.Tile;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    public final int originalTileSize = 16; // 16x16 tile
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels


    //World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    // public final int worldWidth = tileSize * maxWorldCol; // 800 pixels
    // public final int worldHeight = tileSize * maxWorldRow; // 800 pixels

    // FPS
    int FPS = 60;

    public TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public Thread gameThread;

    //Entity and object
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];
    public Entity npc[] = new Entity[10];

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    //game state
    public  int gameState = 1;
    public final int playState = 1;
    public final int pauseState = 2;

    public void setupGame() {
        aSetter.setObject();
        aSetter.setNPC();
        playMusic(0);
        gameState = playState;
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
        if(gameState == playState){
            player.update();
        }
        if (gameState == pauseState) {
            //nothing
        }

    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; //type casting

        tileM.draw(g2);
        
        for(int i = 0; i < obj.length; i++) {
            if(obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }
        //npc 
        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                npc[i].draw(g2);
            }
        }
        
        player.draw(g2);

        ui.draw(g2);
        
        g2.dispose();

    }

    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {
        music.stop();
    }

    public void playSE(int i) {
        se.setFile(i);
        se.play();
    }    

}
