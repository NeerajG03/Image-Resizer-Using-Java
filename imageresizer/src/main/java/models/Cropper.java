package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cropper {
    float type;
    File imageFile;
    String typeString;
    int orientation;
    public Cropper(String file,String aspectRatio){
        try {
            imageFile  = new File(file);
            BufferedImage inputImage = ImageIO.read(imageFile);
            int inputWidth = inputImage.getWidth();
            int inputHeight = inputImage.getHeight();
            if (inputWidth > inputHeight) {
                orientation = 1;
            } 
            else{
                orientation = 2;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (aspectRatio.equals("1:1")){
            type = 1;
            typeString = "1x1";
        }
        else if(aspectRatio.equals("4:3")){
            if (orientation == 1){
                type = (float)(4.0/3);
            }
            else{ 
                type = (float)(3.0/4);
            }
            typeString = "4x3";
        }   
        else{
            type = (orientation == 1) ? (float)(16.0/9) : (float)(9.0/16);
            typeString = "16x9";
        } 
        System.out.println(type);
    }
    
    public int crop(){
        int cropX,cropY,cropHeight,cropWidth;
        String outputPath = imageFile.getParent();
        System.out.println(type+"  "+typeString);
        try{
            BufferedImage inputImage = ImageIO.read(imageFile);
            String[] parts = imageFile.getName().split("\\.");
            int inputWidth = inputImage.getWidth();
            int inputHeight = inputImage.getHeight();
            cropWidth = (int)(Math.min(inputWidth, inputHeight * type));
            cropHeight = (int)(cropWidth * (1 / type));
            cropX = (inputWidth - cropWidth) / 2;
            cropY = (inputHeight - cropHeight) / 2;
            BufferedImage croppedImage = inputImage.getSubimage(cropX, cropY, cropWidth, cropHeight);
            System.out.println(outputPath + "\\Cropped_" + parts[0] + "_" + typeString + "." +parts[1]);
            ImageIO.write(croppedImage, parts[1], new File(outputPath + "\\Cropped_" + parts[0] + "_" + typeString + "." +parts[1] ));

        } catch (IOException e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
}

