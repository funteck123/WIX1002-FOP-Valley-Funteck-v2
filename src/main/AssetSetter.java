package main;


import Monster.Monster_Orc;
import Monster.Monster_Skeleton;
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
    
    
       
    }

    public void setMonster() {
        gp.monster[0] = new Monster_Orc(gp);
        gp.monster[0].worldX = gp.tileSize * 23;
        gp.monster[0].worldY = gp.tileSize * 31;
         gp.monster[1] = new Monster_Orc(gp);
        gp.monster[1].worldX = gp.tileSize * 23;
        gp.monster[1].worldY = gp.tileSize * 32;
         gp.monster[2] = new  Monster_Orc(gp);
        gp.monster[2].worldX = gp.tileSize * 23;
        gp.monster[2].worldY = gp.tileSize * 16;
         gp.monster[3] = new Monster_Orc(gp);
        gp.monster[3].worldX = gp.tileSize * 25;
        gp.monster[3].worldY = gp.tileSize * 26;
         gp.monster[4] = new  Monster_Orc(gp);
        gp.monster[4].worldX = gp.tileSize * 13;
        gp.monster[4].worldY = gp.tileSize * 26;
         gp.monster[5] = new  Monster_Skeleton(gp);
        gp.monster[5].worldX = gp.tileSize * 21;
        gp.monster[5].worldY = gp.tileSize * 12;
          
}}















   
    
