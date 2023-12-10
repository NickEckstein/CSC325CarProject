package bcs.csc.car.api.controller;

import bcs.csc.car.api.firebase.model.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Brian Niski
 */
public class NoLoginImageViewController {

    @FXML
    private ImageView imageView;
    @FXML
    private Button previousButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button nextButton;

    private Vehicle noLoginSelectedVehicle;
    private int imageIndex;

    public void initialize() {
        try {
            noLoginSelectedVehicle = NoLoginViewController.fullObservableList.get(NoLoginViewController.noLoginSelectedIndex);
            imageIndex = 0;
            imageView.setImage(noLoginSelectedVehicle.getImageList().get(imageIndex));
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
            imageView.setImage(noLoginSelectedVehicle.getImageList().get(imageIndex));
        } catch (Exception e) {
            System.out.println("No vehicle selected or end of image list...");
        }
    }

    @FXML
    private void closeButtonOnAction(ActionEvent event) {
        Stage imageStage = NoLoginViewController.noLoginImageStage;
        imageStage.close();
    }

    @FXML
    private void nextButtonOnAction(ActionEvent event) {
        try {
            if (imageIndex < noLoginSelectedVehicle.getImageList().size() - 1) {
                imageIndex++;
            }
            imageView.setImage(noLoginSelectedVehicle.getImageList().get(imageIndex));
        } catch (Exception e) {
            System.out.println("No vehicle selected or end of image list...");
        }
    }

}
