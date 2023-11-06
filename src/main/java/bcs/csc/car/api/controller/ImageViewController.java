package bcs.csc.car.api.controller;

import bcs.csc.car.api.model.Vehicle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImageViewController {

    @FXML
    private ImageView imageView;
    @FXML
    private Button previousButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button nextButton;

    private Vehicle selectedVehicle;
    private int imageIndex;

    public void initialize() {
        try {
            selectedVehicle = VehicleTableController.getVehicleList().get(VehicleTableController.getSelectedVehicleID());
            imageIndex = 0;
            imageView.setImage(selectedVehicle.getImageList().get(imageIndex));
        } catch (Exception e) {
            System.out.println("No vehicle selected or end of image list...");
        }
    }

    @FXML
    private void previousButtonOnAction(ActionEvent event) {
        if (imageIndex > 0) {
            imageIndex--;
        }
        try {
            imageView.setImage(selectedVehicle.getImageList().get(imageIndex));
        } catch (Exception e) {
            System.out.println("No vehicle selected or end of image list...");
        }
    }

    @FXML
    private void closeButtonOnAction(ActionEvent event) {
        Stage imageStage = VehicleTableController.getImageStage();
        imageStage.close();
    }

    @FXML
    private void nextButtonOnAction(ActionEvent event) {
        try {
            if (imageIndex < selectedVehicle.getImageList().size() - 1) {
                imageIndex++;
            }
            imageView.setImage(selectedVehicle.getImageList().get(imageIndex));
        } catch (Exception e) {
            System.out.println("No vehicle selected or end of image list...");
        }
    }

}
