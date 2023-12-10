package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import static bcs.csc.car.api.App.users;
import static bcs.csc.car.api.App.vehicles;
import bcs.csc.car.api.firebase.model.User;
import bcs.csc.car.api.firebase.utils.FirebaseCollectionUtils;
import bcs.csc.car.api.firebase.model.Vehicle;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 *
 * @author Brian
 */
public class NoLoginViewController {

    @FXML
    private Button refreshButton;
    @FXML
    private Button exitButton;
    @FXML
    private Label statusLabel;
    @FXML
    private TableView<Vehicle> tableView;
    @FXML
    private TableColumn<Vehicle, String> makeTableColumn;
    @FXML
    private TableColumn<Vehicle, String> modelTableColumn;
    @FXML
    private TableColumn<Vehicle, Integer> yearTableColumn;
    @FXML
    private TableColumn<Vehicle, String> colorTableColumn;
    @FXML
    private TableColumn<Vehicle, String> fuelTypeTableColumn;
    @FXML
    private TableColumn<Vehicle, Integer> milesTableColumn;
    @FXML
    private TableColumn<Vehicle, Integer> accidentsTableColumn;
    @FXML
    private TableColumn<Vehicle, Double> priceTableColumn;
    @FXML
    private Button viewImagesButton;
    @FXML
    private Button contactSellerButton;
    @FXML
    private TextArea additionalInformationTextArea;
    @FXML
    private TextField searchTextField;

    public static ObservableList<Vehicle> fullObservableList = FXCollections.observableArrayList();
    public static Stage noLoginImageStage = new Stage();
    public static int noLoginSelectedIndex = -1;

    public void initialize() {
        fullObservableList.clear();
        makeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Make"));
        modelTableColumn.setCellValueFactory(new PropertyValueFactory<>("Model"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colorTableColumn.setCellValueFactory(new PropertyValueFactory<>("Color"));
        fuelTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("FuelType"));
        milesTableColumn.setCellValueFactory(new PropertyValueFactory<>("Miles"));
        accidentsTableColumn.setCellValueFactory(new PropertyValueFactory<>("Accidents"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        for (int i = 0; i < App.vehicles.size(); i++) {
            fullObservableList.add(App.vehicles.get(i));
        }
        tableView.setItems(fullObservableList);
    }

    @FXML
    private void openLoginView(ActionEvent event) {
        try {
            if (App.user == null) {
                App.setRoot(App.VIEW_PATH + "loginView");
            } else {
                App.setRoot(App.VIEW_PATH + "sellerView");
            }
        } catch (IOException ex) {

        }
    }

    @FXML
    private void getSelectedRecordOnMousePress(MouseEvent event) {
        noLoginSelectedIndex = -1;
        try {
            noLoginSelectedIndex = tableView.getSelectionModel().getSelectedIndex();
            additionalInformationTextArea.setText(fullObservableList.get(noLoginSelectedIndex).getAdditionalInformation());
            statusLabel.setText("A vehicle has been selected");
        } catch (Exception e) {
            if (noLoginSelectedIndex == -1) {
                statusLabel.setText("A vehicle has not been selected");
            }
        }
    }

    @FXML
    private void openImagesView(ActionEvent event) {
        if (noLoginSelectedIndex != -1) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class
                        .getResource(App.VIEW_PATH + "noLoginImageView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                noLoginImageStage = new Stage();
                noLoginImageStage.setScene(new Scene(root1));
                noLoginImageStage.setTitle("Image Viewer");
                noLoginImageStage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
    }

    @FXML
    private void openContactSellerView(ActionEvent event) {
        if (noLoginSelectedIndex != -1) {
            Alert sellerInformationAlert = new Alert(AlertType.INFORMATION);
            sellerInformationAlert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            sellerInformationAlert.setTitle("Contact Seller");
            sellerInformationAlert.setHeaderText("Seller Information");
            sellerInformationAlert.setContentText(FirebaseCollectionUtils.getSellerInformationFromEmail(fullObservableList.get(noLoginSelectedIndex).getEmail()));
            sellerInformationAlert.showAndWait();
        }
    }

    @FXML
    private void refreshFirebase(ActionEvent event) {
        fullObservableList.clear();
        tableView.getItems().clear();
        ApiFuture<QuerySnapshot> future = App.fstore.collection("Users").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                users = new LinkedList<>();
                for (QueryDocumentSnapshot document : documents) {
                    String firstName = (String) document.getData().get("First_Name");
                    String lastName = (String) document.getData().get("Last_Name");
                    String email = (String) document.getData().get("Email");
                    String phoneNumber = (String) document.getData().get("Phone_Number");
                    String address = (String) document.getData().get("Address");
                    String password = (String) document.getData().get("Password");
                    User newUser = new User(firstName, lastName, email, phoneNumber, address, password);
                    users.add(newUser);
                    System.out.println("User= " + newUser);
                }
            } else {
                System.out.println("No user data");
            }
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        future = App.fstore.collection("Vehicles").get();
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                vehicles = new LinkedList<>();
                for (QueryDocumentSnapshot document : documents) {
                    String email = (String) document.getData().get("Email");
                    String make = (String) document.getData().get("Make");
                    String model = (String) document.getData().get("Model");
                    int year = Integer.parseInt((String) document.getData().get("Year"));
                    String color = (String) document.getData().get("Color");
                    String fuelType = (String) document.getData().get("FuelType");
                    int miles = Integer.parseInt((String) document.getData().get("Miles"));
                    int accidents = Integer.parseInt((String) document.getData().get("Accidents"));
                    double price = Double.parseDouble((String) document.getData().get("Price"));
                    String additionalInformation = (String) document.getData().get("Additional_Information");
                    Vehicle newVehicle = new Vehicle(email, make, model, year, color, fuelType, miles, accidents, price, additionalInformation);
                    vehicles.add(newVehicle);
                    System.out.println("Vehicle= " + newVehicle);
                }
            } else {
                System.out.println("No vehicle data");
            }
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < App.vehicles.size(); i++) {
            fullObservableList.add(App.vehicles.get(i));
        }
    }

}
