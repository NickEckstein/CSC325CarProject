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

/**
 * FXML Controller class
 *
 * @author Meraj Ali
 */
public class LoginWindowController implements Initializable {
    
    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;
    
    
    String username;
    String password;
    

    @FXML
    void onClickLoginPressed(ActionEvent event) {

    }

    @FXML
    void verifyPassword(ActionEvent event) {

    }

    @FXML
    void verifyUsername(ActionEvent event) {

    } 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
}
