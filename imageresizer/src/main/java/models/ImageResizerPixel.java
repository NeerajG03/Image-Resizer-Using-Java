package models;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import interfaces.Resizer;
public class ImageResizerPixel implements Resizer {
    File inputFile;
    public ImageResizerPixel (String filename){
        inputFile = new File(filename);
    }
    @Override
    public int resize(int reductionRate){
        double reduceby = reductionRate/100.0;
        System.out.println(reduceby + " -> reduce by");
        try {
            String[] parts = inputFile.getName().split("\\.");
            BufferedImage inputImage = ImageIO.read(inputFile);

            int newWidth = (int) (inputImage.getWidth() * (1 - reduceby));
            int newHeight = (int) (inputImage.getHeight() * (1 - reduceby));
            System.out.println(newWidth + " " +newHeight);
            BufferedImage outputImage = new BufferedImage(newWidth, newHeight, inputImage.getType());

            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(inputImage, 0, 0, newWidth, newHeight, null);
            g2d.dispose();


            File outputFile = new File(inputFile.getParent()+"\\Resized_" + parts[0] + "." + parts[1]);
            ImageIO.write(outputImage, parts[1], outputFile);

            System.out.println("Image resized successfully.");
        } catch (IOException ex) {
            System.err.println("Error resizing image: " + ex.getMessage());
            ex.printStackTrace();
            return -1;
        }
        return 1;
    }


}
