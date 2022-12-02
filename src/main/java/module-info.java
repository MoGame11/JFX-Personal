module at.mogame11.javafxselfmade {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens at.mogame11.javafxselfmade to javafx.fxml;
    exports at.mogame11.javafxselfmade;
}