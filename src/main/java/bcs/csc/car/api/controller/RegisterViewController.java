package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import bcs.csc.car.api.firebase.model.User;
import bcs.csc.car.api.firebase.utils.FirebaseCollectionUtils;
import bcs.csc.car.api.utils.Validation;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Brian Niski
 */
public class RegisterViewController {

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button createAccountButton;

    /**
     * Function to create a new account upon filling out the form
     * @param event 
     */
    @FXML
    private void createAccount(ActionEvent event) {
        if (!(firstNameTextField.getText().isEmpty() && lastNameTextField.getText().isEmpty() && emailTextField.getText().isEmpty() && phoneNumberTextField.getText().isEmpty() && addressTextField.getText().isEmpty() && passwordField.getText().isEmpty()
                && confirmPasswordField.getText().isEmpty())) {
            if (((Validation.validateFirstName(firstNameTextField.getText()) && (Validation.validateLastName(lastNameTextField.getText())) && (Validation.validateEmail(emailTextField.getText()))) && (Validation.validatePhone(phoneNumberTextField.getText())))) {
                System.out.println("Validation passed!");
                if (passwordField.getText().equals(confirmPasswordField.getText())) {
                    User user = new User(firstNameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(), phoneNumberTextField.getText(), addressTextField.getText(), passwordField.getText());
                    if (!FirebaseCollectionUtils.scanCollectionForMatchingEmail(user.getEmail())) {
                        System.out.println("New user with unique email: " + user.getEmail());
                        FirebaseCollectionUtils.addUserToCollection(user);
                        App.users.add(user);
                        try {
                            App.setRoot(App.VIEW_PATH + "loginView");
                        } catch (IOException ex) {

                        }
                    }
                }
            }
        }
    }

    /**
     * Return to the login view
     * @param event 
     */
    @FXML
    private void goBackToLoginView(ActionEvent event) {
        try {
            App.setRoot(App.VIEW_PATH + "loginView");
        } catch (IOException ex) {

        }
    }

}
