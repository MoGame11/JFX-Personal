package at.mogame11.javafxselfmade;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("LogInView.fxml"))));
        //new LogInController();
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 720,480));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}