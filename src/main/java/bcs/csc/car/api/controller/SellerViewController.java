package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import bcs.csc.car.api.firebase.model.Vehicle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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

    public static ObservableList<Vehicle> sellerObservableList = FXCollections.observableArrayList();
    public static Stage sellerImageStage = new Stage();
    public static int sellerSelectedIndex = -1;
    private static boolean isSelected = false;

    public void initialize() {
        sellerObservableList.clear();
        makeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Make"));
        modelTableColumn.setCellValueFactory(new PropertyValueFactory<>("Model"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colorTableColumn.setCellValueFactory(new PropertyValueFactory<>("Color"));
        fuelTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("FuelType"));
        milesTableColumn.setCellValueFactory(new PropertyValueFactory<>("Miles"));
        accidentsTableColumn.setCellValueFactory(new PropertyValueFactory<>("Accidents"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        for (int i = 0; i < App.vehicles.size(); i++) {
            if (App.vehicles.get(i).getEmail().equals(App.user.getEmail())) {
                sellerObservableList.add(App.vehicles.get(i));
            }
        }
        tableView.setItems(sellerObservableList);
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
        if (isSelected) {
            try {
                App.setRoot(App.VIEW_PATH + "editRecordView");
            } catch (IOException ex) {

            }
        }
    }

    @FXML
    private void openDeleteRecordView(ActionEvent event) {
        if (isSelected) {
            try {
                App.setRoot(App.VIEW_PATH + "deleteRecordView");
            } catch (IOException ex) {

            }
        }
    }

    @FXML
    private void exportTable(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV", "*.CSV"));
        File selectedFile = fileChooser.showSaveDialog(null);
        String content = "";
        if (selectedFile != null) {
            PrintStream outFile = null;
            for (int i = 0; i < sellerObservableList.size(); i++) {
                content += sellerObservableList.get(i).getMake() + "," + sellerObservableList.get(i).getModel() + "," + sellerObservableList.get(i).getYear() + "," + sellerObservableList.get(i).getColor() + "," + sellerObservableList.get(i).getFuelType() + "," + sellerObservableList.get(i).getMiles() + "," + sellerObservableList.get(i).getAccidents() + "," + sellerObservableList.get(i).getPrice() + "," + sellerObservableList.get(i).getAdditionalInformation() + "\n";
            }
            try {
                outFile = new PrintStream(selectedFile);
                outFile.print(content);
            } catch (FileNotFoundException ex) {
            }
            outFile.close();
            statusLabel.setText("Saved file to " + selectedFile.getAbsolutePath());
        }
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
        sellerSelectedIndex = -1;
        try {
            sellerSelectedIndex = tableView.getSelectionModel().getSelectedIndex();
            additionalInformationTextArea.setText(sellerObservableList.get(sellerSelectedIndex).getAdditionalInformation());
            isSelected = true;
            statusLabel.setText("A vehicle has been selected");
        } catch (Exception e) {
            if (sellerSelectedIndex == -1) {
                isSelected = false;
                statusLabel.setText("A vehicle has not been selected");
            }
        }
    }

    @FXML
    private void openImagesView(ActionEvent event) {
        if (isSelected) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(App.VIEW_PATH + "sellerImageView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                sellerImageStage = new Stage();
                sellerImageStage.setScene(new Scene(root1));
                sellerImageStage.setTitle("Image Viewer");
                sellerImageStage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
    }

}
