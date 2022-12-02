package at.mogame11.javafxselfmade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private Button signUpButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    void cancelAction(ActionEvent event) {
        System.out.println("Cancel Action");
    }

    @FXML
    void logInAction(ActionEvent event) {
        System.out.println("Log In Action");
    }

    @FXML
    void signUpAction(ActionEvent event) {
        System.out.println("Sign Up Action");
    }

}
