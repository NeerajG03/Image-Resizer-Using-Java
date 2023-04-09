package com.ntmt;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomepageController {
    @FXML
    private void switchToCrop() throws IOException {
        App.setRoot("croppage");
    } 
    @FXML
    private void switchToResize() throws IOException {
        App.setRoot("resizepage");
    }   
    @FXML
    private void switchToUpscale() throws IOException {
        App.setRoot("upscalepage");
    } 
    @FXML
    private void switchToFormat() throws IOException {
        App.setRoot("formatpage");
    } 
    @FXML
    private void switchToPreset() throws IOException {
        App.setRoot("presetpage");
    } 
}
