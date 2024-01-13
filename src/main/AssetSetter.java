package main;

import Monster.*;
import entity.*;
import object.*;

public class AssetSetter {

    GamePanel gp;
    Monster monster;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject () {

        gp.obj[0] = new OBJ_Door(gp);
        gp.obj[0].worldX = gp.tileSize * 21;
        gp.obj[0].worldY = gp.tileSize * 22;

        // gp.obj[0] = new OBJ_Chest(gp);
        // gp.obj[0].worldX = gp.tileSize * 20;
        // gp.obj[0].worldY = gp.tileSize * 20;

    }

    public void setNPC() {
        gp.npc[0] = new NPC_warrior(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;
    }

    public void setMonster() {
        gp.monster[0] = monster.new Monster_Orc(gp);
        gp.monster[0].worldX = gp.tileSize * 23;
        gp.monster[0].worldY = gp.tileSize * 33;

        gp.monster[1] = monster.new Monster_Skeleton(gp);
        gp.monster[1].worldX = gp.tileSize * 23;
        gp.monster[1].worldY = gp.tileSize * 32;

        gp.monster[2] = monster.new Monster_Goblin(gp);
        gp.monster[2].worldX = gp.tileSize * 23;
        gp.monster[2].worldY = gp.tileSize * 37;

        gp.monster[3] = monster. new Monster_Orc(gp);
        gp.monster[3].worldX = gp.tileSize * 23;
        gp.monster[3].worldY = gp.tileSize * 29;

        gp.monster[4] = monster.new Monster_Goblin(gp);
        gp.monster[4].worldX = gp.tileSize * 21;
        gp.monster[4].worldY = gp.tileSize * 37;
    }
}
