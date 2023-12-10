package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import bcs.csc.car.api.firebase.utils.FirebaseCollectionUtils;
import bcs.csc.car.api.model.Vehicle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brian
 */
public class SellerViewController {

    @FXML
    private Label userNameLabel;
    @FXML
    private Button browseVehiclesButton;
    @FXML
    private Button addRecordButton;
    @FXML
    private Button editRecordButton;
    @FXML
    private Button deleteRecordButton;
    @FXML
    private Button exportTableButton;
    @FXML
    private Button logoutButton;
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
    private TextArea additionalInformationTextArea;

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

        FirebaseCollectionUtils.readLoggedInToSellerObservableList();

        userNameLabel.setText(App.user.getFirstName() + " " + App.user.getLastName());
    }

    @FXML
    private void openVehicleBrowserView(ActionEvent event) {
        try {
            App.setRoot(App.VIEW_PATH + "noLoginView");
        } catch (IOException ex) {

        }
    }

    @FXML
    private void openAddRecordView(ActionEvent event) {
        try {
            App.setRoot(App.VIEW_PATH + "addRecordView");
        } catch (IOException ex) {

        }
    }

    @FXML
    private void openEditRecordView(ActionEvent event) {
        if (selectedIndex != -1) {
            try {
                App.setRoot(App.VIEW_PATH + "editRecordView");
            } catch (IOException ex) {

            }
        }
    }

    @FXML
    private void openDeleteRecordView(ActionEvent event) {
        if (selectedIndex != -1) {
            try {
                App.setRoot(App.VIEW_PATH + "deleteRecordView");
            } catch (IOException ex) {

            }
        }
    }

    @FXML
    private void exportTable(ActionEvent event) {
    }

    @FXML
    private void openLoginView(ActionEvent event) {
        App.user = null;
        try {
            App.setRoot(App.VIEW_PATH + "loginView");
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
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(App.VIEW_PATH + "sellerImageView.fxml"));
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

}
