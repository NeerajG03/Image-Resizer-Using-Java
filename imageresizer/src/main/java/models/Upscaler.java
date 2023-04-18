package models;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

public class Upscaler {
    File inputFile;
    public Upscaler(String s){
        inputFile = new File(s);
    }
    public int upscale(){
        int upscaleFactor = 2; 
        String[] parts = inputFile.getName().split("\\.");
        File  outputFile = new File(inputFile.getParent() + "\\Upscaled_" + parts[0] + "." + parts[1]);
        try{
            BufferedImage inputImage = ImageIO.read(inputFile);

            int width = inputImage.getWidth();
            int height = inputImage.getHeight();

            int newWidth = width * upscaleFactor;
            int newHeight = height * upscaleFactor;
            BufferedImage outputImage = new BufferedImage(newWidth, newHeight, inputImage.getType());

            Graphics2D g2d = outputImage.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.drawImage(inputImage, 0, 0, newWidth, newHeight, null);
            g2d.dispose();
            float scaleFactor = 1.2f;
            float offset = 0.0f;
            RescaleOp rescaleOp = new RescaleOp(scaleFactor, offset, null);
            rescaleOp.filter(outputImage, outputImage);

            // Write the upscaled and filtered image to the output file
            ImageIO.write(outputImage, parts[1], outputFile);

            System.out.println("Image upscaled and filtered successfully.");
        } catch (IOException e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
}
