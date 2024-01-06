package main;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
public class UtilityTool {
    public BufferedImage scaleImage(BufferedImage oringinal, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(width, height, oringinal.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(oringinal, 0, 0, width, height, null);
        g2.dispose();
        return scaledImage;
    }
}
    

