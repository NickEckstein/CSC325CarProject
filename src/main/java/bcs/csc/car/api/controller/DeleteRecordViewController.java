package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import static bcs.csc.car.api.controller.SellerViewController.sellerObservableList;
import bcs.csc.car.api.firebase.utils.FirebaseCollectionUtils;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author Brian Niski
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

    private static int selectedIndex;

    public void initialize() {
        selectedIndex = SellerViewController.sellerSelectedIndex;
        makeLabel.setText(sellerObservableList.get(selectedIndex).getMake());
        modelLabel.setText(sellerObservableList.get(selectedIndex).getModel());
        yearLabel.setText(String.valueOf(sellerObservableList.get(selectedIndex).getYear()));
        colorLabel.setText(sellerObservableList.get(selectedIndex).getColor());
        fuelTypeLabel.setText(sellerObservableList.get(selectedIndex).getFuelType());
        milesLabel.setText(String.valueOf(sellerObservableList.get(selectedIndex).getMiles()));
        accidentsLabel.setText(String.valueOf(sellerObservableList.get(selectedIndex).getAccidents()));
        priceLabel.setText(String.valueOf(sellerObservableList.get(selectedIndex).getPrice()));
        additionalInformationTextArea.setText(sellerObservableList.get(selectedIndex).getAdditionalInformation());
        try {
            numberOfImagesLabel.setText(String.valueOf(sellerObservableList.get(selectedIndex).getImageList().size()));
        } catch (NullPointerException e) {
            numberOfImagesLabel.setText("0");
        }
    }

    /**
     * Delete selected vehicle from Firebase collection and refresh the table
     * @param event 
     */
    @FXML
    private void deleteRecord(ActionEvent event) {
        try {
            CollectionReference collection = App.fstore.collection("Vehicles");
            Query query = collection.whereEqualTo("Email", sellerObservableList.get(selectedIndex).getEmail());

            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            for (QueryDocumentSnapshot document : querySnapshot.get().getDocuments()) {
                String documentId = document.getId();
                DocumentReference docRef = App.fstore.collection("Vehicles").document(documentId);
                ApiFuture<DocumentSnapshot> future = docRef.get();
                DocumentSnapshot doc = future.get();
                if (doc.exists()) {
                    System.out.println("Document data to be deleted= " + document.getData());
                    App.fstore.collection("Vehicles").document(documentId).delete();
                    try {
                        FirebaseCollectionUtils.refreshCollection();
                        App.setRoot(App.VIEW_PATH + "sellerView");
                        break;
                    } catch (IOException ex) {

                    }
                }
            }
        } catch (InterruptedException | ExecutionException ex) {

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
