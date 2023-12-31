package bcs.csc.car.api.controller;

import static bcs.csc.car.api.App.legalMake_ModelList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

/**
 * FXML Controller Test Class
 * @author Brian Niski
 */
public class SampleController {

    @FXML
    private Button generateRandomVehicleButton;

    /**
     * Alert popup to generate a random vehicle with the matching make and model
     * @param event 
     */
    @FXML
    private void generateRandomLegalVehicle(ActionEvent event) {
        try {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.getDialogPane().setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
            alert.setTitle("Random Legal Vehicle");
            alert.setHeaderText("Make and Model");
            int randomIndex = (int) (Math.random() * legalMake_ModelList.size());
            alert.setContentText(legalMake_ModelList.get(randomIndex).toString());
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println("Failure");
        }
    }

}
