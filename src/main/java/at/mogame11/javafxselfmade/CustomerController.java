package at.mogame11.javafxselfmade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CustomerController {

    @FXML
    private Button logInButton;

    @FXML
    void logInAction(ActionEvent event) {
        changeSceneToLogIn();
    }

    private void changeSceneToLogIn() {
        try {
            Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("LogInView.fxml"))));

            Stage window = (Stage) logInButton.getScene().getWindow();
            window.setScene(new Scene(root, 720,480));
        } catch (IOException iox) {
            System.err.println("Exception: " + iox);
        }
    }

}

