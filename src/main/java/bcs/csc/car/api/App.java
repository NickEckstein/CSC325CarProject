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
import bcs.csc.car.api.firebase.model.SampleUser;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @authors Meraj Ali, Nicholas Eckstein, Brian Niski, Bryant Velasquez
 */
public class App extends Application {

    /**
     * File Access Strings
     */
    public static final String VIEW_PATH = "view/";
    public static final String RESOURCES_PATH = "./src/main/resources/";
    public static final String LOAD_FXML_FILE_NAME = "sampleFirebase";

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

    @Override
    public void start(Stage stage) throws IOException {
        fstore = contxtFirebase.firebase();
        fauth = FirebaseAuth.getInstance();

        scene = new Scene(loadFXML(VIEW_PATH + LOAD_FXML_FILE_NAME));
        stage.setTitle("Firebase Test Suite");
        stage.setScene(scene);
        stage.show();
        
//        System.out.println("Add new user to Firebase");
//        SampleUser.addUser(new SampleUser("test@email.com", "averysecurepassword"));
//        SampleUser.addUser(new SampleUser("test2@email.com", "averysecurepassword2"));
        System.out.println("Success");
        
        SampleUser.readUsers();
        
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
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
            LinkedList<LegalMake_Model> legalMake_ModelList = DataParser.readFile("Legal Make_Model List.dat");
            App.legalMake_ModelList = legalMake_ModelList;
            System.out.println("LOADED LEGAL MAKE_MODEL FILE SUCCESSFULLY");
        }
        launch();
    }

}
