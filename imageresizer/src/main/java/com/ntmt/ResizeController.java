package com.ntmt;

import java.io.IOException;
import javafx.fxml.FXML;

public class ResizeController {
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

}


