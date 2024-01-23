package main;

import java.util.Random;

//import Monster.*;
import entity.*;
//import object.*;

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
        
        int randX = gp.player.worldX;
        int randY = gp.player.worldY;

        gp.npc[0] = new Monster_Skeleton(gp);

        while (randX == gp.player.worldX || randY == gp.player.worldY) {
            randX = rand.nextInt(4) + 36;
            randY = rand.nextInt(4) + 7;
            gp.npc[0].worldX = gp.tileSize * randX;
            gp.npc[0].worldY = gp.tileSize * randY;
        }

        randX = gp.player.worldX;
        randY = gp.player.worldY;
        
        gp.npc[1] = new Monster_Witch(gp);

        while (randX == gp.player.worldX || randY == gp.player.worldY) {
            randX = rand.nextInt(1) + 38;
            randY = rand.nextInt(1) + 38;
            gp.npc[1].worldX = gp.tileSize * randX;
            gp.npc[1].worldY = gp.tileSize * randY;
        }

        randX = gp.player.worldX;
        randY = gp.player.worldY;

        gp.npc[2] = new Monster_Goblin(gp);

        while (randX == gp.player.worldX || randY == gp.player.worldY) {
            randX = rand.nextInt(3) + 22;
            randY = rand.nextInt(10) + 20;
            gp.npc[2].worldX = gp.tileSize * randX;
            gp.npc[2].worldY = gp.tileSize * randY;
        }


        gp.npc[3] = new Monster_Goblin(gp);
        gp.npc[3].worldX = gp.tileSize * 23;
        gp.npc[3].worldY = gp.tileSize * 29;

        gp.npc[4] = new Monster_Orc(gp);
        gp.npc[4].worldX = gp.tileSize * 23;
        gp.npc[4].worldY = gp.tileSize * 15;

        gp.npc[5] = new Monster_Orc(gp);
        gp.npc[5].worldX = gp.tileSize * 23;
        gp.npc[5].worldY = gp.tileSize * 37;

        gp.npc[6] =  new Monster_Goblin(gp);
        gp.npc[6].worldX = gp.tileSize * 23;
        gp.npc[6].worldY = gp.tileSize * 33;

        gp.npc[7] = new Monster_Goblin(gp);
        gp.npc[7].worldX = gp.tileSize * 22;
        gp.npc[7].worldY = gp.tileSize * 33;

        gp.npc[8] = new Monster_Harpy(gp);
        gp.npc[8].worldX = gp.tileSize * 13;
        gp.npc[8].worldY = gp.tileSize * 33;

        gp.npc[9] = new Monster_Orc(gp);
        gp.npc[9].worldX = gp.tileSize * 12;
        gp.npc[9].worldY = gp.tileSize * 33;

        gp.npc[10] = new Monster_Skeleton(gp);
        gp.npc[10].worldX = gp.tileSize * 11;
        gp.npc[10].worldY = gp.tileSize * 10;

    }

    public void setMonster() {
        
    }
}
