package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import bcs.csc.car.api.firebase.utils.FirebaseCollectionUtils;
import bcs.csc.car.api.firebase.model.Vehicle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Brian Niski
 */
public class AddRecordViewController {

    @FXML
    private TextField yearTextField;
    @FXML
    private TextField colorsTextField;
    @FXML
    private TextField fuelTypesTextField;
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

    /**
     * Stub
     * @param event 
     */
    @FXML
    private void openImageFileChooser(ActionEvent event) {
    }

    /**
     * Stub
     * @param event 
     */
    @FXML
    private void openRemoveImageView(ActionEvent event) {
    }

    /**
     * Add a new vehicle record to the Firebase collection
     * @param event 
     */
    @FXML
    private void addRecord(ActionEvent event) {
        try {
            Vehicle vehicle = new Vehicle(App.user.getEmail(),
                    makeTextField.getText(),
                    modelTextField.getText(),
                    Integer.parseInt(yearTextField.getText()),
                    colorsTextField.getText(),
                    fuelTypesTextField.getText(),
                    Integer.parseInt(milesTextField.getText()),
                    Integer.parseInt(accidentsTextField.getText()),
                    Double.parseDouble(priceTextField.getText()),
                    additionalInformationTextArea.getText()
            );
            FirebaseCollectionUtils.addVehicleToCollection(vehicle);
            App.vehicles.add(vehicle);
            System.out.println("Document added to collection= " + vehicle.toString());
            App.setRoot(App.VIEW_PATH + "sellerView");
        } catch (NumberFormatException | IOException e) {

        }
    }

    /**
     * Change scene to seller view
     * @param event 
     */
    @FXML
    private void goBackToSellerView(ActionEvent event) {
        try {
            App.setRoot(App.VIEW_PATH + "sellerView");
        } catch (IOException ex) {

        }
    }

}
