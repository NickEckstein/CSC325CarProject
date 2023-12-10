package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Brian
 */
public class EditRecordViewController {

    @FXML
    private TextField makeSearchTextField;
    @FXML
    private TextField modelSearchTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField colorsTextField;
    @FXML
    private ComboBox<String> fuelTypesComboBox;
    @FXML
    private TextField milesTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextArea additionalInformationTextArea;
    @FXML
    private Button addImageButton;
    @FXML
    private Button removeImageButton;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField accidentsTextField;

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
    private void editRecord(ActionEvent event) {
    }

    @FXML
    private void goBackToSellerView(ActionEvent event) {
        try {
            App.setRoot(App.VIEW_PATH + "sellerView");
        } catch (IOException ex) {

        }
    }

}
