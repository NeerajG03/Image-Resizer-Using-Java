package com.ntmt;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class PPController {
    @FXML
    private TextField fileSize;

    @FXML
    private void handleSubmit() {
        System.out.println("Img Height" + fileSize.getText());
    }

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("homepage");
    } 
}
