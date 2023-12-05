/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcs.csc.car.api.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Meraj Ali
 */
public class LoginWindowController implements Initializable {
    
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
}
