package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity {

    public OBJ_Chest (GamePanel gp) {

        super(gp);

        name = "Door";
        down1 = setup("/res/objects/chest");

        collision = true;
        
    }



}
