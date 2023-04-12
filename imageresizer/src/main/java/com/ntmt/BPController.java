package com.ntmt;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;
import java.io.File;

public class BPController {
    public List<File> files;

    @FXML private Button chooseFilesButton;
    @FXML private AnchorPane rootPane;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private Label selectedFilesLabel;
    @FXML private TextField imgHeight;
    @FXML private Button submit;
    @FXML private Button cancel;

    public void initialize() {

        rootPane.setStyle("-fx-background-color: #2a2b32;");
        label1.setStyle("-fx-text-fill: #f8f8f8;");
        selectedFilesLabel.setStyle("-fx-text-fill: #f8f8f8;");
        label2.setStyle("-fx-text-fill: #f8f8f8;");

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
        }
        System.out.println("file height ->"+imgHeight.getText()+"px");
    }

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("homepage");
    } 
}