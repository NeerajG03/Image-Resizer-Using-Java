package com.ntmt;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;

public class SPController {

    @FXML private TextField filePath;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private Label label3;
    @FXML private BorderPane rootPane;
    @FXML private TextField fileName;
    @FXML private TextField imgHeight;
    @FXML private Button chooseFilesButton;

    @FXML
    private void handleChooseFileButtonPressed() {
        System.out.println("");
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

    public void initialize(){

        rootPane.setStyle("-fx-background-color: #2a2b32;");
        label1.setStyle("-fx-text-fill: #f8f8f8;");
        label2.setStyle("-fx-text-fill: #f8f8f8;");
        label3.setStyle("-fx-text-fill: #f8f8f8;");

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