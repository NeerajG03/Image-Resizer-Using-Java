package models;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import interfaces.Resizer;

public class ImageResizerFile implements Resizer {
    File inputFile;
    public ImageResizerFile (String filename){
        inputFile = new File(filename);
    }

    @Override
    public int resize(int reductionRate){
        double targetFileSize = (double)reductionRate * 1024;
        double compressionQuality;
        try {
            BufferedImage inputImage = ImageIO.read(inputFile);
            String[] parts = inputFile.getName().split("\\.");
            int width = inputImage.getWidth();
            int height = inputImage.getHeight();
            compressionQuality = (targetFileSize) / ((inputFile).length()); 
            System.out.println(" -> " + compressionQuality);
            BufferedImage outputImage = new BufferedImage((int)(width * compressionQuality),(int)(height * compressionQuality), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(inputImage, 0, 0, (int)(width * compressionQuality), (int)(height * compressionQuality), null);
            g2d.dispose();
            ImageIO.write(outputImage, parts[1], new File(inputFile.getParent() + "\\Resized_" + parts[0] + "." +parts[1]));
            
        } catch (IOException e) {
            System.err.println("Failed to reduce image file size: " + e.getMessage());
        }
        return 1;
    }
}