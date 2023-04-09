package com.ntmt;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;

public class UpscaleController {

    @FXML
    private TextField filePath;

    @FXML
    private TextField fileName;
    @FXML private Button chooseFilesButton;
    @FXML
    private void handleChooseFileButtonPressed() {
        System.out.println("");
    }

    @FXML
    private void handleSubmit() {
        // Save file using the information in the text fields
        System.out.println("File path" + filePath.getText());
        System.out.println("File name" + fileName.getText());
    }

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("homepage");
    } 

    public void initialize(){
        chooseFilesButton.setOnAction(event -> {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPEG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            filePath.setText(selectedFile.getParent());
            fileName.setText(selectedFile.getName());
        }
    });
    }
}