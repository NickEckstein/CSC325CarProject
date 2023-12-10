package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import bcs.csc.car.api.firebase.utils.FirebaseCollectionUtils;
import bcs.csc.car.api.model.Vehicle;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Brian
 */
public class AddRecordViewController {

    @FXML
    private TextField yearTextField;
    @FXML
    private TextField colorsTextField;
    @FXML
    private ComboBox<String> fuelTypesComboBox;
    @FXML
    private TextField milesTextField;
    @FXML
    private TextField accidentsTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextArea additionalInformationTextArea;
    @FXML
    private Button addImageButton;
    @FXML
    private Button removeImageButton;
    @FXML
    private Label numberOfImagesLabel;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField makeTextField;

    public void initialize() {
        fuelTypesComboBox.setItems(FXCollections.observableArrayList(App.fuelTypes));
    }

    @FXML
    private void openImageFileChooser(ActionEvent event) {
    }

    @FXML
    private void openRemoveImageView(ActionEvent event) {
    }

    @FXML
    private void addRecord(ActionEvent event) {
        try {
            Vehicle vehicle = new Vehicle(App.user.getEmail(),
                    makeTextField.getText(),
                    modelTextField.getText(),
                    Integer.parseInt(yearTextField.getText()),
                    colorsTextField.getText(),
                    fuelTypesComboBox.getValue(),
                    Integer.parseInt(milesTextField.getText()),
                    Integer.parseInt(accidentsTextField.getText()),
                    Double.parseDouble(priceTextField.getText()),
                    additionalInformationTextArea.getText()
            );
            FirebaseCollectionUtils.addVehicleToCollection(vehicle);
            App.setRoot(App.VIEW_PATH + "sellerView");
        } catch (NumberFormatException | IOException e) {

        }
    }

    @FXML
    private void goBackToSellerView(ActionEvent event) {
        try {
            App.setRoot(App.VIEW_PATH + "sellerView");
        } catch (IOException ex) {

        }
    }

}
