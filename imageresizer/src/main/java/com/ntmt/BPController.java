package com.ntmt;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;
import java.io.File;

public class BPController {
    public List<File> files;

    @FXML private Button chooseFilesButton;
    @FXML private Label selectedFilesLabel;
    @FXML private TextField imgHeight;
    @FXML private Button submit;
    @FXML private Button cancel;

    public void initialize() {
        chooseFilesButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
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