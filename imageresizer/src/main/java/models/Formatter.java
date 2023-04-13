package models;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Formatter {
    File imgFile;
    String type;
    public Formatter(String file, String t){
        imgFile = new File(file);
        type = t;
    } 

    public int format(){
        String[] parts = imgFile.getName().split("\\.");
        File  output_file = new File(imgFile.getParent() + "\\Formatted_" + parts[0] + "."+type);
        try{
            BufferedImage inputImage = ImageIO.read(imgFile);
            ImageIO.write(inputImage, type, output_file);
            System.out.println("Formatting Complete!");
        } catch (IOException e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }    
}
