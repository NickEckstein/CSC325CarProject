package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author Brian
 */
public class DeleteRecordViewController {

    @FXML
    private Label makeLabel;
    @FXML
    private Label modelLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label colorLabel;
    @FXML
    private Label fuelTypeLabel;
    @FXML
    private Label milesLabel;
    @FXML
    private Label accidentsLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private TextArea additionalInformationTextArea;
    @FXML
    private Label numberOfImagesLabel;
    @FXML
    private Button confirmButton;

    @FXML
    private void deleteRecord(ActionEvent event) {
    }

    @FXML
    private void goBackToSellerView(ActionEvent event) {
        try {
            App.setRoot(App.VIEW_PATH + "sellerView");
        } catch (IOException ex) {

        }
    }
    
}
