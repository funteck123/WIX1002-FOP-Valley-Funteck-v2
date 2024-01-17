package tile;

//import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

    public GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        
        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/maps/worldV2.txt");
    }

    public void getTileImage() {
        
           //placeholder
            setup(0,"grass00" , false);
            setup(1,"grass00", false);
            setup(2,"grass00", false);
            setup(3,"grass00", false);
            setup(4,"grass00", false);
            setup(5,"grass00", false);
            setup(6,"grass00", false);
            setup(7,"grass00", false);
            setup(8,"grass00", false);
            setup(9,"grass00", false);

            setup(10,"subtraction_blue" , false);
            setup(11,"plus_white", false); 
            setup(12,"water00", true);
            setup(13,"water01", true);
            setup(14,"power_white", true);
            setup(15,"power_white", true);
            setup(16,"power_white", true);
            setup(17,"power_white", true);
            setup(18,"power_white", true);
            setup(19,"power_white", true);
            setup(20,"power_white", true);
            setup(21,"power_white", true);
            setup(22,"power_white", true);
            setup(23,"power_white", true);
            setup(24,"power_white", true);
            setup(25,"power_white", true);
            setup(26,"subtraction_blue", false);
            setup(27,"subtraction_blue", false);
            setup(28,"subtraction_blue", false);
            setup(29,"plus_white", false);
            setup(30,"plus_white", false);
            setup(31,"plus_white", false);
            setup(32,"plus_white", false);
            setup(33,"subtraction_blue", false);
            setup(34,"subtraction_blue", false);
            setup(35,"subtraction_blue", false);
            setup(36,"subtraction_blue", false);
            setup(37,"subtraction_blue", false);
            setup(38,"subtraction_blue", false);
           
            setup(39,"subtraction_red", false);
            setup(40,"exclamationMark", true);
            setup(41,"hash _white", true);
            setup(42,"hash_white", true);

            
        }
    public void setup(int index ,String name,boolean collision){
        UtilityTool uTool = new UtilityTool();
        try {tile[index]=new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/"+name+".png"));
            tile[index].image=uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize); 
            tile[index].collision=collision;
  
    }
    catch (IOException e){
        e.printStackTrace();
        
    }
}
    
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
                    String numbers[] = line.split(" ");
                    
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if (col >= gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
                

                }
                br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY,  null);    
            }
            worldCol++;

            if(worldCol >= gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }

        }


    }


}