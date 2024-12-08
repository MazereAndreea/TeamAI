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

public class AppController extends ShortestPath {

    public Label shelf_route;
    public Label label_route;
    @FXML
    private Button nextButton;

    @FXML
    public TextField shelfTextField;

    @FXML
    public TextArea messageLabel;

    @FXML
    private void initialize() {
        shelfTextField.setVisible(false);
        messageLabel.setVisible(false);
        label_route.setVisible(false);
        shelf_route.setText("Comanda noua!");
        // This method is called automatically after the FXML is loaded
        updateContext();
    }

    @FXML
    private void handleNextButtonClick() {
        if(textArea.isEmpty()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orderComplete.fxml"));
                Parent nextSceneRoot = fxmlLoader.load();

                Scene nextScene = new Scene(nextSceneRoot);

                Stage currentStage = (Stage) nextButton.getScene().getWindow();

                currentStage.setScene(nextScene);

                currentStage.setTitle("Order completed!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        updateContext();
    }

    private void updateContext() {
        if(textArea.isEmpty()) {
            nextButton.setText("Incepe comanda");
        }
        else {
            nextButton.setText("Urmatorul produs");
            shelfTextField.setText("Raionul " + stepsText);
            messageLabel.setText(String.valueOf(textArea));
            shelfTextField.setVisible(true);
            messageLabel.setVisible(true);
            label_route.setVisible(true);
        }
        calcNextProduct();
    }
}
