package com.ntmt;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class ResizeController {
    @FXML
    private BorderPane rootPane;

    @FXML
    private void goToBF() throws IOException {
        App.setRoot("batchfilepage");
    } 
    @FXML
    private void goToBP() throws IOException {
        App.setRoot("batchpixelpage");
    }   
    @FXML
    private void goToSP() throws IOException {
        App.setRoot("singlepixelpage");
    } 
    @FXML
    private void goToSF() throws IOException {
        App.setRoot("singlefilepage");
    } 

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("homepage");
    } 

    public void initialize(){
        rootPane.setStyle("-fx-background-color: #2a2b32;");
    }
}


