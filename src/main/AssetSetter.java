package main;

import java.util.Random;

//import Monster.*;
import entity.*;
import object.*;

public class AssetSetter {

    GamePanel gp;
    
    Random rand = new Random(); 

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject () {

        // gp.obj[0] = new OBJ_Door(gp);
        // gp.obj[0].worldX = gp.tileSize * 21;
        // gp.obj[0].worldY = gp.tileSize * 22;

        // gp.obj[0] = new OBJ_Chest(gp);
        // gp.obj[0].worldX = gp.tileSize * 20;
        // gp.obj[0].worldY = gp.tileSize * 20;

    }

    public void setNPC() {
        
        int randX = 25;
        int randY = 25;

        gp.npc[0] = new Monster_Skeleton(gp);

        while (randX == 25 || randY == 25) {
            randX = rand.nextInt(4) + 36;
            randY = rand.nextInt(4) + 7;
            gp.npc[0].worldX = gp.tileSize * randX;
            gp.npc[0].worldY = gp.tileSize * randY;
        }
        
        gp.npc[1] = new Monster_Skeleton(gp);
        while (randX == 25 || randY == 25) {
            randX = rand.nextInt(10) + 19;
            randY = rand.nextInt(3) + 20;
            gp.npc[1].worldX = gp.tileSize * randX;
            gp.npc[1].worldY = gp.tileSize * randY;
        }

        gp.npc[2] = new Monster_Orc(gp);
        while (randX == 25 || randY == 25) {
            randX = rand.nextInt(10) + 19;
            randY = rand.nextInt(3) + 20;
            gp.npc[2].worldX = gp.tileSize * randX;
            gp.npc[2].worldY = gp.tileSize * randY;
        }


        gp.npc[3] = new Monster_Goblin(gp);
        gp.npc[3].worldX = gp.tileSize * 23;
        gp.npc[3].worldY = gp.tileSize * 33;

        gp.npc[4] = new Monster_Orc(gp);
        gp.npc[4].worldX = gp.tileSize * 23;
        gp.npc[4].worldY = gp.tileSize * 32;

        gp.npc[5] = new Monster_Goblin(gp);
        gp.npc[5].worldX = gp.tileSize * 23;
        gp.npc[5].worldY = gp.tileSize * 37;

        gp.npc[6] =  new Monster_Harpy(gp);
        gp.npc[6].worldX = gp.tileSize * 23;
        gp.npc[6].worldY = gp.tileSize * 29;

        gp.npc[7] = new Monster_Witch(gp);
        gp.npc[7].worldX = gp.tileSize * 21;
        gp.npc[7].worldY = gp.tileSize * 37;
    }

    public void setMonster() {
        
    }
}
