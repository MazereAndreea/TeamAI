package com.teamai.hackitall.instorepicking;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController extends ShortestPath {

    @FXML
    private Label welcomeText; // Existing welcomeText label

    @FXML
    private Button nextButton;

    @FXML
    public TextField shelfTextField;

    @FXML
    public TextArea messageLabel;

    @FXML
    private void initialize() {
        // This method is called automatically after the FXML is loaded
        updateContext();
    }

    @FXML
    private void handleNextButtonClick() {
        if(!calcNextProduct()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orderComplete.fxml"));
                Parent nextSceneRoot = fxmlLoader.load();

                Scene nextScene = new Scene(nextSceneRoot);

                Stage currentStage = (Stage) nextButton.getScene().getWindow();

                currentStage.setScene(nextScene);

                currentStage.setTitle("Next Scene");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        updateContext();
    }

    private void updateContext() {
        shelfTextField.setText("Raftul " + stepsText);
        messageLabel.setText(String.valueOf(textArea));
    }
}
