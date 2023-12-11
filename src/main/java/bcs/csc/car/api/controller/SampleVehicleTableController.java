package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import bcs.csc.car.api.model.LegalMake_Model;
import bcs.csc.car.api.model.SampleVehicle;
import bcs.csc.car.api.sql.model.battery.BatteryType;
import bcs.csc.car.api.sql.model.body.BodyStyle;
import bcs.csc.car.api.sql.model.drive.DriveType;
import bcs.csc.car.api.sql.model.engine.EngineModel;
import bcs.csc.car.api.sql.model.engine.EngineModelPattern;
import bcs.csc.car.api.sql.model.fueltype.FuelType;
import bcs.csc.car.api.sql.model.make_model.Make;
import bcs.csc.car.api.sql.model.make_model.Model;
import bcs.csc.car.api.sql.model.transmission.Transmission;
import bcs.csc.car.api.sql.model.vehicle.VehicleType;
import bcs.csc.car.api.sql.utils.DataParser;
import java.util.LinkedList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller Test Class
 * @author Brian Niski
 */
public class SampleVehicleTableController {

    @FXML
    private Button showImagesButton;
    @FXML
    private Button addVehicleButton;
    @FXML
    private Label statusLabel;

    private LinkedList<BatteryType> batteryTypeList = new LinkedList<>();
    private LinkedList<BodyStyle> bodyStyleList = new LinkedList<>();
    private LinkedList<DriveType> driveTypeList = new LinkedList<>();
    private LinkedList<EngineModel> engineModelList = new LinkedList<>();
    private LinkedList<EngineModelPattern> engineModelPatternList = new LinkedList<>();
    private LinkedList<FuelType> fuelTypeList = new LinkedList<>();
    private LinkedList<LegalMake_Model> legalMake_ModelList = new LinkedList<>();
    private LinkedList<Transmission> transmissionList = new LinkedList<>();
    private LinkedList<VehicleType> vehicleTypeList = new LinkedList<>();

    @FXML
    private TableView<SampleVehicle> vehicleTableView;
    @FXML
    private TableColumn<SampleVehicle, Long> idTableColumn;
    @FXML
    private TableColumn<SampleVehicle, BatteryType> batteryTypeTableColumn;
    @FXML
    private TableColumn<SampleVehicle, BodyStyle> bodyStyleTableColumn;
    @FXML
    private TableColumn<SampleVehicle, DriveType> driveTypeTableColumn;
    @FXML
    private TableColumn<SampleVehicle, EngineModel> engineModelTableColumn;
    @FXML
    private TableColumn<SampleVehicle, FuelType> fuelTypeTableColumn;
    @FXML
    private TableColumn<SampleVehicle, Make> makeTableColumn;
    @FXML
    private TableColumn<SampleVehicle, Model> modelTableColumn;
    @FXML
    private TableColumn<SampleVehicle, Transmission> transmissionTableColumn;
    @FXML
    private TableColumn<SampleVehicle, VehicleType> vehicleTypeTableColumn;
    @FXML
    private TableColumn<SampleVehicle, Long> yearTableColumn;
    @FXML
    private TableColumn<SampleVehicle, Long> milesTableColumn;
    @FXML
    private TableColumn<SampleVehicle, String> colorTableColumn;
    @FXML
    private TableColumn<SampleVehicle, String> conditionDescriptionTableColumn;
    @FXML
    private TableColumn<SampleVehicle, Long> numberOfAccidentsTableColumn;
    @FXML
    private TableColumn<SampleVehicle, String> accidentDescriptionTableColumn;
    @FXML
    private TableColumn<SampleVehicle, Double> priceTableColumn;

    private static ObservableList<SampleVehicle> vehicleList = FXCollections.observableArrayList();

    private static Stage imageStage = new Stage();
    private static int selectedVehicleID;
    @FXML
    private Button removeVehicleButton;

    public void initialize() {
        batteryTypeList = DataParser.readFile("Battery Type List.dat");
        bodyStyleList = DataParser.readFile("Body Style List.dat");
        driveTypeList = DataParser.readFile("Drive Type List.dat");
        engineModelList = DataParser.readFile("Engine Model List.dat");
        fuelTypeList = DataParser.readFile("Fuel Type List.dat");
        legalMake_ModelList = DataParser.readFile("Legal Make_Model List.dat");
        transmissionList = DataParser.readFile("Transmission List.dat");
        vehicleTypeList = DataParser.readFile("Vehicle Type List.dat");

        idTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, Long>("vehicleID"));
        batteryTypeTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, BatteryType>("batteryType"));
        bodyStyleTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, BodyStyle>("bodyStyle"));
        driveTypeTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, DriveType>("driveType"));
        engineModelTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, EngineModel>("engineModel"));
        fuelTypeTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, FuelType>("fuelType"));
        makeTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, Make>("make"));
        modelTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, Model>("model"));
        transmissionTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, Transmission>("transmission"));
        vehicleTypeTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, VehicleType>("vehicleType"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, Long>("year"));
        milesTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, Long>("miles"));
        colorTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, String>("color"));
        conditionDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, String>("conditionDescription"));
        numberOfAccidentsTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, Long>("numberOfAccidents"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, Double>("price"));
        accidentDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<SampleVehicle, String>("accidentDescription"));

        vehicleTableView.setItems(vehicleList);
        statusLabel.setText("");
    }

    /**
     * Load image view in new stage
     * @param event 
     */
    @FXML
    private void showImagesView(ActionEvent event) {
        if (!(statusLabel.getText().equals(""))) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(App.VIEW_PATH + "imageView.fxml"));
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

    public static Stage getImageStage() {
        return imageStage;
    }

    public static int getSelectedVehicleID() {
        return selectedVehicleID;
    }

    public TableView<SampleVehicle> getVehicleTableView() {
        return vehicleTableView;
    }

    public static ObservableList<SampleVehicle> getVehicleList() {
        return vehicleList;
    }

    /**
     * Generate a random vehicle and add it to the list
     * @param event 
     */
    @FXML
    private void showAddVehicleView(ActionEvent event) {
        // Random vehicle info for now
        LegalMake_Model randomLegalMake_Model = legalMake_ModelList.get((int) (Math.random() * legalMake_ModelList.size() - 1));
        SampleVehicle vehicle = new SampleVehicle(batteryTypeList.get(randomIndexFromList(batteryTypeList)).getBatteryName(), bodyStyleList.get(randomIndexFromList(bodyStyleList)).getBodyStyleName(), driveTypeList.get(randomIndexFromList(driveTypeList)).getDriveTypeName(), engineModelList.get(randomIndexFromList(engineModelList)).getEngineModelName(), fuelTypeList.get(randomIndexFromList(fuelTypeList)).getName(), randomLegalMake_Model.getMakeName(), randomLegalMake_Model.getModelName(), transmissionList.get(randomIndexFromList(transmissionList)).getTransmissionName(), vehicleTypeList.get(randomIndexFromList(vehicleTypeList)).getVehicleTypeName(), 0, 0, "Blank", "None", 0, 25);
        vehicleList.add(vehicle);
        vehicleTableView.getSelectionModel().clearSelection();
    }

    /**
     * Obtain a random index from a linked list
     * @param <T>
     * @param linkedList
     * @return 
     */
    private <T> int randomIndexFromList(LinkedList<T> linkedList) {
        return (int) (Math.random() * linkedList.size());
    }

    /**
     * Track selected vehicle from mouse click
     * @param event 
     */
    @FXML
    private void onMousePressed(MouseEvent event) {
        try {
            selectedVehicleID = vehicleTableView.getSelectionModel().getSelectedIndex();
            statusLabel.setText("Selected " + vehicleList.get(selectedVehicleID).getMake() + ", " + vehicleList.get(selectedVehicleID).getModel());
        } catch (Exception e) {
//            System.out.println("Failure on obtaining selection from mouse press...");
        }
    }

    /**
     * Delete selected vehicle from table
     * @param event 
     */
    @FXML
    private void removeSelectedVehicle(ActionEvent event) {
        try {
            selectedVehicleID = vehicleTableView.getSelectionModel().getSelectedIndex();
            vehicleTableView.getItems().remove(selectedVehicleID);
            vehicleTableView.getSelectionModel().clearSelection();
        } catch (Exception e) {
//            System.out.println("Failure on removing selection...");
        }
    }

}
