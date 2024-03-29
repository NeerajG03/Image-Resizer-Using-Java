package com.ntmt;

import java.io.IOException;

import models.Cropper;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;

import java.io.File;



public class CropController {
    private String selectedValue;
    @FXML private TextField filePath;
    @FXML private Label label1;
    @FXML private RadioButton left1;
    @FXML private RadioButton left2;
    @FXML private RadioButton left3;
    @FXML private Label label2;
    @FXML private Label output;
    @FXML private Label label3;
    @FXML private BorderPane rootPane;
    @FXML private ToggleGroup group;
    @FXML private TextField fileName;
    @FXML private Button chooseFilesButton;
    
    @FXML
    private void handleChooseFileButtonPressed() {
        System.out.println("");
    }

    @FXML
    private void handleSubmit() {
        System.out.println("File path : " + filePath.getText());
        System.out.println("File name : " + fileName.getText());
        System.out.println("Aspect Ratio : " + selectedValue);
        Cropper crop = new Cropper(filePath.getText() +"/"+fileName.getText(),selectedValue);
        int value = crop.crop();
        if (value == 1){
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
        
        left1.setStyle("-fx-text-fill: #f8f8f8;");
        left2.setStyle("-fx-text-fill: #f8f8f8;");
        left3.setStyle("-fx-text-fill: #f8f8f8;");

        label1.setStyle("-fx-text-fill: #f8f8f8;");
        label2.setStyle("-fx-text-fill: #f8f8f8;");
        label3.setStyle("-fx-text-fill: #f8f8f8;");
        output.setStyle("-fx-text-fill: #f8f8f8;");
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

    group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            // Get the selected Toggle from the ToggleGroup
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            selectedValue = selectedRadioButton.getText();
            System.out.println("Selected value: " + selectedValue);
        }
    });

    }
}