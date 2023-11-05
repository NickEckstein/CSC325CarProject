module bcs.csc.car.api {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens bcs.csc.car.api.controller to javafx.fxml;
    exports bcs.csc.car.api;
}
