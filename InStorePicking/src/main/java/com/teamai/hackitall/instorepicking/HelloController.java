package com.teamai.hackitall.instorepicking;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button nextButton; // This links to the fx:id in the FXML file

    @FXML
    private void NextProduct(int i) {
        // Change the text of the button when it is clicked
        nextButton.setText("Go to Product ");
    }
}