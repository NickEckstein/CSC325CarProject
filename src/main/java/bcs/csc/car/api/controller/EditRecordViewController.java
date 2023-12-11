package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import static bcs.csc.car.api.controller.SellerViewController.sellerObservableList;
import bcs.csc.car.api.firebase.model.Vehicle;
import bcs.csc.car.api.firebase.utils.FirebaseCollectionUtils;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Brian Niski
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
    private TextField fuelTypeTextField;
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

    private static int selectedIndex;

    public void initialize() {
        selectedIndex = SellerViewController.sellerSelectedIndex;
        makeSearchTextField.setText(sellerObservableList.get(selectedIndex).getMake());
        modelSearchTextField.setText(sellerObservableList.get(selectedIndex).getModel());
        yearTextField.setText(String.valueOf(sellerObservableList.get(selectedIndex).getYear()));
        colorsTextField.setText(sellerObservableList.get(selectedIndex).getColor());
        fuelTypeTextField.setText(sellerObservableList.get(selectedIndex).getFuelType());
        milesTextField.setText(String.valueOf(sellerObservableList.get(selectedIndex).getMiles()));
        accidentsTextField.setText(String.valueOf(sellerObservableList.get(selectedIndex).getAccidents()));
        priceTextField.setText(String.valueOf(sellerObservableList.get(selectedIndex).getPrice()));
        additionalInformationTextArea.setText(sellerObservableList.get(selectedIndex).getAdditionalInformation());
    }

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
     * Edit selected vehicle in Firebase collection and update table
     * Implementation is to delete the old version and add the new version
     * @param event
     * @return 
     */
    @FXML
    private Vehicle editRecord(ActionEvent event) {
        Vehicle originalVehicle = sellerObservableList.get(selectedIndex);
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
                    App.fstore.collection("Vehicles").document(documentId).delete();
                    FirebaseCollectionUtils.refreshCollection();
                    break;
                }
            }

            Vehicle vehicle = new Vehicle(App.user.getEmail(),
                    makeSearchTextField.getText(),
                    modelSearchTextField.getText(),
                    Integer.parseInt(yearTextField.getText()),
                    colorsTextField.getText(),
                    fuelTypeTextField.getText(),
                    Integer.parseInt(milesTextField.getText()),
                    Integer.parseInt(accidentsTextField.getText()),
                    Double.parseDouble(priceTextField.getText()),
                    additionalInformationTextArea.getText()
            );
            FirebaseCollectionUtils.addVehicleToCollection(vehicle);
            App.vehicles.add(vehicle);
            System.out.println("Document edited into collection= " + vehicle.toString());
            App.setRoot(App.VIEW_PATH + "sellerView");
        } catch (InterruptedException | ExecutionException | NumberFormatException | IOException ex) {

        }
        return originalVehicle;
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
