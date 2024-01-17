package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import data.SaveLoad;
import entity.Entity;
import entity.Player;
//import object.SuperObject;
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
    public EventHandler eHandler = new EventHandler(this);
    public SaveLoad saveLoad = new SaveLoad(this);

    //Entity and object
    public Player player = new Player(this, keyH);
    public Entity obj[] = new Entity[10];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];
    ArrayList <Entity> entityList = new ArrayList<>();


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    //game state
    public int gameState = 0;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int fightState = 5;
    public final int gameOverState = 6;
    public final int saveState = 7;


    public void setupGame() {
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        playMusic(0);
        gameState = titleState;
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

            
            //player
            player.update();
            //npc
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                }
            }
        
            //monster
            for(int i = 0 ; i < monster.length; i++) {

                if(monster[i] != null) {
                    monster[i].update();
                }
            }
        }
        else if (gameState == pauseState) {
            //nothing
        }
        else if (gameState == dialogueState) {
            //nothing
        }
        else if (gameState == characterState) {
            //nothing
        }
        else if (gameState == fightState) {
            //nothing
        }
        else if (gameState == gameOverState) {
            //nothing
        }

    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; //type casting

        //if gameState(gameState== titleScreen) {

        //} else {

        //}
        
        // TITLE SCREEN
        if(gameState == titleState) {
            ui.draw(g2);
        } else {
            
            //draw tiles
            tileM.draw(g2);

            //add entities to the list
            entityList.add(player);
            for (int i = 0; i < entityList.size(); i++) {
                if (npc[i] != null) {
                    entityList.add(npc[i]);
                }
            }
            for (int i = 0; i < entityList.size(); i++) {
                if (obj[i] != null) {
                    entityList.add(obj[i]);
                }
            }


            for (int i = 0; i < entityList.size(); i++) {
                if (monster[i] != null) {
                    entityList.add(monster[i]);
                }
            }







            //sort
            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }
            });

            //draw entities
            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            } 

            //empty the list
            entityList.clear();
            
            ui.draw(g2);
            
            //g2.dispose();

        }

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
