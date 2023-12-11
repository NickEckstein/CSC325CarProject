package bcs.csc.car.api.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 * FXML Controller Test Class
 *
 * @author Meraj Ali
 */
public class LoginWindowController {
    
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button loginButton;
    
    @FXML
    private Label status;

    @FXML
    void onClickLoginPressed(ActionEvent event) {
        
        if (!(username.getText().isBlank() && password.getText().isBlank())) {
            status.setText("Login successful!");
        } 
        else {
            status.setText("Invalid user/password. Please try again.");
        }
    }

    
}
