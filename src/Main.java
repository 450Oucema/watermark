import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    /*
    public static void main(String[] args) {
        File sourceImageFile = new File("C:/Projets/watermark/img/photo.jpg");
        File watermarkImageFile = new File("C:/Projets/watermark/img/watermark.png");
        File destImageFile = new File("C:/Projets/watermark/img/watermarked.png");

        watermark(watermarkImageFile, sourceImageFile, destImageFile);
    }
    */

    static void watermark(File watermarkImageFile, File sourceImageFile, File finalImageFile) {
        try {
            BufferedImage sourceImage = ImageIO.read(sourceImageFile);
            BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);

            Graphics2D graphics2D = (Graphics2D) sourceImage.getGraphics();
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3F);
            graphics2D.setComposite(alphaComposite);

            int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
            int topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;

            graphics2D.drawImage(watermarkImage, topLeftX, topLeftY, null);
            ImageIO.write(sourceImage, "png", finalImageFile);
            graphics2D.dispose();

            System.out.println("Watermark ajouté à l'image");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
