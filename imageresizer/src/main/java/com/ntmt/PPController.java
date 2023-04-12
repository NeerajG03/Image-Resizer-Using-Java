package com.ntmt;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class PPController {
    @FXML
    private TextField fileSize;
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Label label1;
    
    @FXML
    private void handleSubmit() {
        System.out.println("Img Height" + fileSize.getText());
    }

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("homepage");
    } 

    public void initialize(){
        rootPane.setStyle("-fx-background-color: #2a2b32;");
        label1.setStyle("-fx-text-fill: #f8f8f8;");

    }
}
