package main;

import entity.*;

public class AssetSetter {
    
    GamePanel gp;
    
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject () {
    }

    public void setNPC() {
        gp.npc[0] = new NPC_warrior(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;
    
    
        gp.npc[1] = new Monster_Witch(gp);
        gp.npc[1].worldX = gp.tileSize * 20;
        gp.npc[1].worldY = gp.tileSize * 20;
    }

}















   
    
