package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import bcs.csc.car.api.firebase.utils.FirebaseCollectionUtils;
import bcs.csc.car.api.model.Vehicle;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

    public static ObservableList<Vehicle> observableList = FXCollections.observableArrayList();
    public static Stage imageStage = new Stage();
    public static int selectedIndex = -1;

    public void initialize() {
        makeTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("make"));
        modelTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("model"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("year"));
        colorTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("color"));
        fuelTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("fuel_type"));
        milesTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("miles"));
        accidentsTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("accidents"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("price"));

        FirebaseCollectionUtils.readAllToObservableList();

        FilteredList<Vehicle> filteredData = new FilteredList<>(observableList, b -> true);
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(vehicle -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (vehicle.getMake().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (vehicle.getModel().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        }
        );
        SortedList<Vehicle> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty()
                .bind(tableView.comparatorProperty());

        tableView.setItems(observableList);
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
        selectedIndex = -1;
        try {
            selectedIndex = tableView.getSelectionModel().getSelectedIndex();
            additionalInformationTextArea.setText(observableList.get(selectedIndex).getAdditionalInformation());
            statusLabel.setText("A vehicle has been selected");
        } catch (Exception e) {
            if (selectedIndex == -1) {
                statusLabel.setText("A vehicle has not been selected");
            }
        }
    }

    @FXML
    private void openImagesView(ActionEvent event) {
        if (selectedIndex != -1) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class
                        .getResource(App.VIEW_PATH + "noLoginImageView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                imageStage = new Stage();
                imageStage.setScene(new Scene(root1));
                imageStage.setTitle("Image Viewer");
                imageStage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
    }

    @FXML
    private void openContactSellerView(ActionEvent event) {
        if (selectedIndex != -1) {
            Alert sellerInformationAlert = new Alert(AlertType.INFORMATION);
            sellerInformationAlert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            sellerInformationAlert.setTitle("Contact Seller");
            sellerInformationAlert.setHeaderText("Seller Information");
            sellerInformationAlert.setContentText(FirebaseCollectionUtils.getSellerInformationFromEmail(observableList.get(selectedIndex).getEmail()));
        }
    }

}
