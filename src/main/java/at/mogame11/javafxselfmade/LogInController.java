package at.mogame11.javafxselfmade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LogInController {

    @FXML
    private Button cancelButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    public LogInController() {
        initScene();
    }

    private void initScene() {
        //errorLabel.setText("");
    }

    @FXML
    void cancelAction(ActionEvent event) {
        changeSceneToCustomer();
        System.out.println("Cancel Action");
    }

    @FXML
    void logInAction(ActionEvent event) {
        System.out.println("Log In Action");
        String userName = usernameTextField.getText();
        String password = passwordField.getText();
        //System.out.println("Username: " + userName);
        //System.out.println("Passwort: " + password);
        if (isUserDataCorrect(userName, password)) {
            changeSceneToAdmin();
            System.out.println("Success");
        } else {
            //errorLabel.setText("Wrong Log-In Data");
            System.out.println("Wrong Log-In Data");
        }
    }

    private boolean isUserDataCorrect(String userName, String userPassword) {
        return new FileHandler().isCorrectInput(userName, userPassword);
    }

    private void changeSceneToAdmin() {
        try {
            Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminView.fxml"))));

            Stage window = (Stage) logInButton.getScene().getWindow();
            window.setScene(new Scene(root, 720,480));
        } catch (IOException iox) {
            System.err.println("Exception: " + iox);
        }
    }

    private void changeSceneToCustomer() {
        try {
            Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("CustomerView.fxml"))));

            Stage window = (Stage) cancelButton.getScene().getWindow();
            window.setScene(new Scene(root, 720,480));
        } catch (IOException iox) {
            System.err.println("Exception: " + iox);
        }
    }

}
