package com.ntmt;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class SPController {

    @FXML
    private TextField filePath;

    @FXML
    private TextField fileName;

    @FXML
    private TextField imgHeight;

    @FXML
    private void handleChooseFileButtonPressed() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            filePath.setText(selectedFile.getParent());
            fileName.setText(selectedFile.getName());
        }
    }

    @FXML
    private void handleSubmit() {
        // Save file using the information in the text fields
        System.out.println("File path ->" + filePath.getText());
        System.out.println("File height ->" + imgHeight.getText());
        System.out.println("File name ->" + fileName.getText());
    }

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("homepage");
    } 
}