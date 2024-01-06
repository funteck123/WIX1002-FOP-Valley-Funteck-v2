package main;

import java.awt.Rectangle;

public class EvenHandler {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    public EvenHandler(GamePanel gp) {
        this.gp = gp;


        eventRect= new Rectangle();
        eventRect.x=23;
        eventRect.y=23;
        eventRect.width=2;
        eventRect.height=2;
        eventRectDefaultX=eventRect.x;
        eventRectDefaultY=eventRect.y;

    }
    public void chechEvent() {
        if (hit (23,23,"up")) {
            System.out.println("HIT");
        }
        
    }
    public boolean hit(int eventcol, int eventrow,String reqDirection) {
        boolean hit = false;
       gp.player.solidArea.x=gp.player.solidAreaDefaultX+gp.player.solidAreaDefaultX;
       gp.player.solidArea.y=gp.player.solidAreaDefaultY+gp.player.solidAreaDefaultY;
       //eventRect.x=eventCol*gp.tileSize+eventRet.x;
      // eventRect.y=eventRow*gp.tileSize+eventRet.y;
       if(gp.player.solidArea.intersects(eventRect)) {
          if (gp.player.direction.contentEquals(reqDirection)||reqDirection.contentEquals("any")) {
              hit = true;
          }
       }
       gp.player.solidArea.x=gp.player.solidAreaDefaultX;
       gp.player.solidArea.y=gp.player.solidAreaDefaultY;
       eventRect.x=eventRectDefaultX;
       eventRect.y=eventRectDefaultY;
        return hit;
    }
    

}
