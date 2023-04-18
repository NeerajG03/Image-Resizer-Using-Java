package com.ntmt;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import models.ImageResizerFile;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;
import java.io.File;

public class BFController {
    public List<File> files;

    @FXML private Button chooseFilesButton;
    @FXML private AnchorPane rootPane;
    @FXML private Label label1;
    @FXML private Label recommend;
    @FXML private Label label3;
    @FXML private Label output;
    @FXML private Label selectedFilesLabel;
    @FXML private TextField fileSize;
    @FXML private Button submit;
    @FXML private Button cancel;

    public void initialize() {
        rootPane.setStyle("-fx-background-color: #2a2b32;");
        label1.setStyle("-fx-text-fill: #f8f8f8;");
        selectedFilesLabel.setStyle("-fx-text-fill: #f8f8f8;");
        label3.setStyle("-fx-text-fill: #f8f8f8;");
        output.setStyle("-fx-text-fill: #f8f8f8;");
        recommend.setStyle("-fx-text-fill: #f8f8f8;");

        chooseFilesButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPEG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            fileChooser.setTitle("Select Files");
            files = fileChooser.showOpenMultipleDialog(chooseFilesButton.getScene().getWindow());
            if (files != null) {
                StringBuilder sb = new StringBuilder();
                for (File file : files) {
                    sb.append(file.getName()).append(", ");
                }
                selectedFilesLabel.setText(sb.toString());
            }
        });
    }

    @FXML
    private void handleSubmit() {
        // Save file using the information in the text fields
        System.out.println("Files ->");
        for (File file : files) {
            System.out.println(file.getName());
            System.out.println(file.getParent());
            // for (File file : files) {
                System.out.println(file.getAbsolutePath());
                try {
                    int size = Integer.parseInt(fileSize.getText());
                    ImageResizerFile resizer = new ImageResizerFile(file.getAbsolutePath());
                    int result = resizer.resize(size);
                    if (result == 1){
                        output.setText("Output Generated!");
                    }
                    else{
                        output.setText("Erro while converting format!");
                    }
                } catch (NumberFormatException n){
                    output.setText("Give valid integer!");
                }
        }
        System.out.println("file size ->"+fileSize.getText());
    }

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("homepage");
    } 
}