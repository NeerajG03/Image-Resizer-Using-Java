package com.ntmt;

import java.io.IOException;
import javafx.fxml.FXML;

public class PresetController {
    @FXML
    private void goToFileSize() throws IOException {
        App.setRoot("filesizepresetpage");
    } 
    @FXML
    private void goToPixel() throws IOException {
        App.setRoot("pixelpresetpage");
    }  

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("homepage");
    } 

}


