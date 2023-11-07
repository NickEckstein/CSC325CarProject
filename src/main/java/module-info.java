module bcs.csc.car.api {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens bcs.csc.car.api.controller to javafx.fxml;
    opens bcs.csc.car.api.model to javafx.base;
    exports bcs.csc.car.api;
}
