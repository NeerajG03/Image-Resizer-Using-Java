package com.ntmt;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FSPController {
    @FXML
    private TextField fileSize;

    @FXML
    private void handleSubmit() {
        // Save file using the information in the text fields
        System.out.println("File Size" + fileSize.getText());
    }

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("homepage");
    } 
}
