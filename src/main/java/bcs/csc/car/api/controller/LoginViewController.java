package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import bcs.csc.car.api.firebase.utils.FirebaseCollectionUtils;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Brian
 */
public class LoginViewController {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button signInButton;
    @FXML
    private Button createAccountButton;
    @FXML
    private Button browseWithoutSigningInButton;

    @FXML
    private void openSellerVehicleTableView(ActionEvent event) {
        if (!(usernameTextField.getText().isEmpty() && passwordTextField.getText().isEmpty())) {
            if (FirebaseCollectionUtils.scanCollectionForMatchingLogin(usernameTextField.getText(), passwordTextField.getText())) {
                try {
                    FirebaseCollectionUtils.updateAppUserUponLogin(usernameTextField.getText(), passwordTextField.getText());
                    App.setRoot(App.VIEW_PATH + "sellerView");
                } catch (IOException ex) {

                }
            } else {

            }
        }
    }

    @FXML
    private void openCreateAccountView(ActionEvent event) {
        try {
            App.setRoot(App.VIEW_PATH + "registerView");
        } catch (IOException ex) {

        }
    }

    @FXML
    private void openNoLoginView(ActionEvent event) {
        try {
            App.setRoot(App.VIEW_PATH + "noLoginView");
        } catch (IOException ex) {

        }
    }

}
