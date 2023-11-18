package bcs.csc.car.api.controller;

import bcs.csc.car.api.App;
import bcs.csc.car.api.model.LegalMake_Model;
import bcs.csc.car.api.model.Vehicle;
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
 *
 * @author Brian Niski
 */
public class VehicleTableController {

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
    private TableView<Vehicle> vehicleTableView;
    @FXML
    private TableColumn<Vehicle, Long> idTableColumn;
    @FXML
    private TableColumn<Vehicle, BatteryType> batteryTypeTableColumn;
    @FXML
    private TableColumn<Vehicle, BodyStyle> bodyStyleTableColumn;
    @FXML
    private TableColumn<Vehicle, DriveType> driveTypeTableColumn;
    @FXML
    private TableColumn<Vehicle, EngineModel> engineModelTableColumn;
    @FXML
    private TableColumn<Vehicle, FuelType> fuelTypeTableColumn;
    @FXML
    private TableColumn<Vehicle, Make> makeTableColumn;
    @FXML
    private TableColumn<Vehicle, Model> modelTableColumn;
    @FXML
    private TableColumn<Vehicle, Transmission> transmissionTableColumn;
    @FXML
    private TableColumn<Vehicle, VehicleType> vehicleTypeTableColumn;
    @FXML
    private TableColumn<Vehicle, Long> yearTableColumn;
    @FXML
    private TableColumn<Vehicle, Long> milesTableColumn;
    @FXML
    private TableColumn<Vehicle, String> colorTableColumn;
    @FXML
    private TableColumn<Vehicle, String> conditionDescriptionTableColumn;
    @FXML
    private TableColumn<Vehicle, Long> numberOfAccidentsTableColumn;
    @FXML
    private TableColumn<Vehicle, Double> priceTableColumn;

    private static ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();

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

        idTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Long>("vehicleID"));
        batteryTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, BatteryType>("batteryType"));
        bodyStyleTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, BodyStyle>("bodyStyle"));
        driveTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, DriveType>("driveType"));
        engineModelTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, EngineModel>("engineModel"));
        fuelTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, FuelType>("fuelType"));
        makeTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Make>("make"));
        modelTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Model>("model"));
        transmissionTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Transmission>("transmission"));
        vehicleTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, VehicleType>("vehicleType"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Long>("year"));
        milesTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Long>("miles"));
        colorTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("color"));
        conditionDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("conditionDescription"));
        numberOfAccidentsTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Long>("numberOfAccidents"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("price"));

        vehicleTableView.setItems(vehicleList);
        statusLabel.setText("");
    }

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

    public TableView<Vehicle> getVehicleTableView() {
        return vehicleTableView;
    }

    public static ObservableList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    @FXML
    private void showAddVehicleView(ActionEvent event) {
        // Random vehicle info for now
        LegalMake_Model randomLegalMake_Model = legalMake_ModelList.get((int) (Math.random() * legalMake_ModelList.size() - 1));
        Vehicle vehicle = new Vehicle(batteryTypeList.get(randomIndexFromList(batteryTypeList)).getBatteryName(), bodyStyleList.get(randomIndexFromList(bodyStyleList)).getBodyStyleName(), driveTypeList.get(randomIndexFromList(driveTypeList)).getDriveTypeName(), engineModelList.get(randomIndexFromList(engineModelList)).getEngineModelName(), fuelTypeList.get(randomIndexFromList(fuelTypeList)).getName(), randomLegalMake_Model.getMakeName(), randomLegalMake_Model.getModelName(), transmissionList.get(randomIndexFromList(transmissionList)).getTransmissionName(), vehicleTypeList.get(randomIndexFromList(vehicleTypeList)).getVehicleTypeName(), 0, 0, "Blank", "None", 0, 25);
        vehicleList.add(vehicle);
        vehicleTableView.getSelectionModel().clearSelection();
    }

    private <T> int randomIndexFromList(LinkedList<T> linkedList) {
        return (int) (Math.random() * linkedList.size());
    }

    @FXML
    private void onMousePressed(MouseEvent event) {
        try {
            selectedVehicleID = vehicleTableView.getSelectionModel().getSelectedIndex();
            statusLabel.setText("Selected " + vehicleList.get(selectedVehicleID).getMake() + ", " + vehicleList.get(selectedVehicleID).getModel());
        } catch (Exception e) {
//            System.out.println("Failure on obtaining selection from mouse press...");
        }
    }

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
