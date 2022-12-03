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

public class AdminController {

    @FXML
    private Button logOutButton;

    @FXML
    void logOutButtonAction(ActionEvent event) {
        changeSceneToCustomer();
    }

    private void changeSceneToCustomer() {
        try {
            Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("CustomerView.fxml"))));

            Stage window = (Stage) logOutButton.getScene().getWindow();
            window.setScene(new Scene(root, 720,480));
        } catch (IOException iox) {
            System.err.println("Exception: " + iox);
        }
    }

}

