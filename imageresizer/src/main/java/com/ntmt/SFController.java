package com.ntmt;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import models.ImageResizerFile;

import java.io.File;

public class SFController {

    @FXML private Button chooseFilesButton;
    @FXML private TextField filePath;
    @FXML private TextField fileName;
    @FXML private TextField fileSize;
    @FXML private Label label1;
    @FXML private Label recommend;
    @FXML private Label label2;
    @FXML private Label label3;
    @FXML private Label output;
    @FXML private BorderPane rootPane;

    @FXML
    private void handleChooseFileButtonPressed() {
        System.out.println("lmao");
    }

    @FXML
    private void handleSubmit() {
        // Save file using the information in the text fields
        System.out.println("File path" + filePath.getText());
        System.out.println("File Size" + fileSize.getText());
        System.out.println("File name" + fileName.getText());
        ImageResizerFile resizer = new ImageResizerFile(filePath.getText()+"\\"+fileName.getText());
        int value = Integer.parseInt(fileSize.getText());
        int res = resizer.resize(value);
        if (res == 1){
            output.setText("Output Generated!");
        }
        else {
            output.setText("Error while generating a crop!");

        }
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
        output.setStyle("-fx-text-fill: #f8f8f8;");

        recommend.setStyle("-fx-text-fill: #f8f8f8;");

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
        long fileSizeBytes = selectedFile.length();
        recommend.setText(recommend.getText()+ "\nSelected file size : " + (fileSizeBytes/1024) + "KB");
    });
    }
}