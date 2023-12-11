package bcs.csc.car.api;

import bcs.csc.car.api.model.LegalMake_Model;
import bcs.csc.car.api.sql.model.battery.BatteryType;
import bcs.csc.car.api.sql.model.body.BodyStyle;
import bcs.csc.car.api.sql.model.drive.DriveType;
import bcs.csc.car.api.sql.model.engine.EngineModel;
import bcs.csc.car.api.sql.model.engine.EngineModelPattern;
import bcs.csc.car.api.sql.model.fueltype.FuelType;
import bcs.csc.car.api.sql.model.identification.Element;
import bcs.csc.car.api.sql.model.make_model.Make;
import bcs.csc.car.api.sql.model.make_model.Make_Model;
import bcs.csc.car.api.sql.model.make_model.Model;
import bcs.csc.car.api.sql.model.transmission.Transmission;
import bcs.csc.car.api.sql.model.vehicle.VehicleType;
import bcs.csc.car.api.sql.utils.DataParser;
import bcs.csc.car.api.sql.utils.SQLiteUtils;
import bcs.csc.car.api.firebase.FirestoreContext;
import bcs.csc.car.api.firebase.model.User;
import bcs.csc.car.api.firebase.model.Vehicle;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.auth.FirebaseAuth;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Project Authors
 * @authors Meraj Ali, Nicholas Eckstein, Brian Niski, Bryant Velasquez
 */
public class App extends Application {

    /**
     * File Access Strings
     */
    public static final String VIEW_PATH = "view/";
    public static final String RESOURCES_PATH = "./src/main/resources/";
    public static final String LOAD_FXML_FILE_NAME = "loginView";

    /**
     * App Objects
     */
    private static Scene scene;
    public static LinkedList<LegalMake_Model> legalMake_ModelList = new LinkedList<>();

    /**
     * Firebase Objects
     */
    public static Firestore fstore;
    public static FirebaseAuth fauth;
    private final FirestoreContext contxtFirebase = new FirestoreContext();

    /**
     * Selected User Upon Login
     */
    public static User user = null;

    /**
     * Final Data Types
     */
    public final static String[] colors = {"Black", "Blue", "Brown", "Gold", "Gray", "Green", "Orange", "Purple", "Red", "Silver", "Tan", "White", "Yellow"};
    public final static String[] fuelTypes = {"Gasoline", "Electric", "Hybrid"};

    /**
     * Data Loaded from Firebase
     */
    public static LinkedList<User> users = new LinkedList();
    public static LinkedList<Vehicle> vehicles = new LinkedList();

    @Override
    public void start(Stage stage) throws IOException {
        fstore = contxtFirebase.firebase();
        fauth = FirebaseAuth.getInstance();

        /**
         * Read Firebase Data
         * Users
         */
        ApiFuture<QuerySnapshot> future = App.fstore.collection("Users").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
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

        /**
         * Read Firebase Data
         * Vehicles
         */
        future = App.fstore.collection("Vehicles").get();
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
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

        /**
         * Setup JavaFX Stage
         */
        scene = new Scene(loadFXML(VIEW_PATH + LOAD_FXML_FILE_NAME), 1080, 796);
        stage.setTitle("Car Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        System.out.println("Scene changed to " + fxml);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        /**
         * Load ALL files from SQL database
         */
        File f = new File("Legal Make_Model List.dat");
        if (!f.exists()) {
            System.out.println("Initializing project files...");
            LinkedList<BatteryType> batteryTypeList = SQLiteUtils.readBatteryTypeData();
            DataParser.saveFile(batteryTypeList, "Battery Type List");

            LinkedList<BodyStyle> bodyStyleList = SQLiteUtils.readBodyStyleData();
            DataParser.saveFile(bodyStyleList, "Body Style List");

            LinkedList<DriveType> driveTypeList = SQLiteUtils.readDriveTypeData();
            DataParser.saveFile(driveTypeList, "Drive Type List");

            LinkedList<EngineModel> engineModelList = SQLiteUtils.readEngineModelData();
            DataParser.saveFile(engineModelList, "Engine Model List");

            LinkedList<EngineModelPattern> engineModelPatternList = SQLiteUtils.readEngineModelPatternData();
            DataParser.saveFile(engineModelPatternList, "Engine Model Pattern List");

            LinkedList<Element> elementList = SQLiteUtils.readElementData();
            DataParser.saveFile(elementList, "Element List");

            LinkedList<FuelType> fuelTypeList = SQLiteUtils.readFuelTypeData();
            DataParser.saveFile(fuelTypeList, "Fuel Type List");

            LinkedList<Make_Model> make_modelList = SQLiteUtils.readMake_ModelData();
            DataParser.saveFile(make_modelList, "Make_Model List");

            LinkedList<Make> makeList = SQLiteUtils.readMakeData();
            DataParser.saveFile(makeList, "Make List");

            LinkedList<Model> modelList = SQLiteUtils.readModelData();
            DataParser.saveFile(modelList, "Model List");

            LinkedList<Transmission> transmissionList = SQLiteUtils.readTransmissionData();
            DataParser.saveFile(transmissionList, "Transmission List");

            LinkedList<VehicleType> vehicleTypeList = SQLiteUtils.readVehicleTypeData();
            DataParser.saveFile(vehicleTypeList, "Vehicle Type List");

            LinkedList<LegalMake_Model> legalMake_ModelList = DataParser.readThroughMake_ModelList(make_modelList, makeList, modelList);
            DataParser.saveFile(legalMake_ModelList, "Legal Make_Model List");

            App.legalMake_ModelList = legalMake_ModelList;
            System.out.println("CREATED PROJECT FILES SUCCESSFULLY");
        } else {
            /**
             * Load matching makes and model groups file
             */
            LinkedList<LegalMake_Model> legalMake_ModelList = DataParser.readFile("Legal Make_Model List.dat");
            App.legalMake_ModelList = legalMake_ModelList;
            System.out.println("LOADED LEGAL MAKE_MODEL FILE SUCCESSFULLY");
        }
        launch();
    }
}
