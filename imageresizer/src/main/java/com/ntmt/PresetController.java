package com.ntmt;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class PresetController {
    @FXML
    private BorderPane rootPane;

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

    public void initialize(){
        rootPane.setStyle("-fx-background-color: #2a2b32;");

    }

}


