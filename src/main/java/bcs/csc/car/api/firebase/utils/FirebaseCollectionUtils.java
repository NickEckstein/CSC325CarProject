package bcs.csc.car.api.firebase.utils;

import bcs.csc.car.api.App;
import bcs.csc.car.api.controller.NoLoginViewController;
import bcs.csc.car.api.controller.SellerViewController;
import bcs.csc.car.api.firebase.model.User;
import bcs.csc.car.api.model.Vehicle;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Brian
 */
public class FirebaseCollectionUtils {
    
    public static boolean scanCollectionForMatchingEmail(String email) {
        ApiFuture<QuerySnapshot> future = App.fstore.collection("Users").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                for (QueryDocumentSnapshot document : documents) {
                    if (document.getData().get("Email").equals(email)) {
                        System.out.println("Found matching email");
                        return true;
                    }
                }
            } else {
                System.out.println("No data");
            }
        } catch (InterruptedException | ExecutionException ex) {
            
        }
        return false;
    }
    
    public static boolean scanCollectionForMatchingLogin(String email, String password) {
        ApiFuture<QuerySnapshot> future = App.fstore.collection("Users").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                for (QueryDocumentSnapshot document : documents) {
                    if (((document.getData().get("Email").equals(email)) && (document.getData().get("Password").equals(password)))) {
                        System.out.println("Found matching email and password");
                        return true;
                    }
                }
            } else {
                System.out.println("No data");
            }
        } catch (InterruptedException | ExecutionException ex) {
            
        }
        return false;
    }
    
    public static void updateAppUserUponLogin(String email, String password) {
        ApiFuture<QuerySnapshot> future = App.fstore.collection("Users").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                for (QueryDocumentSnapshot document : documents) {
                    if (((document.getData().get("Email").equals(email)) && (document.getData().get("Password").equals(password)))) {
                        App.user = new User((String) document.getData().get("First_Name"), (String) document.getData().get("Last_Name"), (String) document.getData().get("Email"), (String) document.getData().get("Phone_Number"), (String) document.getData().get("Address"), (String) document.getData().get("Password"));
                        System.out.println("Logged in: " + App.user.toString());
                    }
                }
            } else {
                System.out.println("No data");
            }
        } catch (InterruptedException | ExecutionException ex) {
            
        }
    }
    
    public static void addUserToCollection(User user) {
        DocumentReference docRef = App.fstore.collection("Users").document(UUID.randomUUID().toString());
        Map<String, Object> data = new HashMap<>();
        data.put("First_Name", user.getFirstName());
        data.put("Last_Name", user.getLastName());
        data.put("Email", user.getEmail());
        data.put("Phone_Number", user.getPhoneNumber());
        data.put("Address", user.getAddress());
        data.put("Password", user.getPassword());
        ApiFuture<WriteResult> result = docRef.set(data);
    }
    
    public static String getSellerInformationFromEmail(String email) {
        ApiFuture<QuerySnapshot> future = App.fstore.collection("Users").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                for (QueryDocumentSnapshot document : documents) {
                    if (document.getData().get("Email").equals(email)) {
                        System.out.println("Found matching email");
                        return "Name: " + document.getData().get("First_Name") + " " + document.getData().get("Last_Name") + "\n"
                                + "Email: " + document.getData().get("Email") + "\n"
                                + "Phone Number: " + document.getData().get("Phone_Number") + "\n"
                                + "Address: " + document.getData().get("Address");
                    }
                }
            } else {
                System.out.println("No data");
            }
        } catch (InterruptedException | ExecutionException ex) {
            
        }
        return "";
    }
    
    public static void readAllToObservableList() {
        ApiFuture<QuerySnapshot> future = App.fstore.collection("Vehicles").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                for (QueryDocumentSnapshot document : documents) {
                    Vehicle vehicle = new Vehicle((String) document.getData().get("Email"),
                            (String) document.getData().get("Make"),
                            (String) document.getData().get("Model"),
                            (Integer) document.getData().get("Year"),
                            (String) document.getData().get("Color"),
                            (String) document.getData().get("Fuel_Type"),
                            (Integer) document.getData().get("Miles"),
                            (Integer) document.getData().get("Accidents"),
                            (Double) document.getData().get("Price"),
                            (String) document.getData().get("Additionl_Information"));
                    NoLoginViewController.observableList.add(vehicle);
                }
            } else {
                System.out.println("No data");
            }
        } catch (InterruptedException | ExecutionException ex) {
            
        }
    }
    
    public static void readLoggedInToSellerObservableList() {
        ApiFuture<QuerySnapshot> future = App.fstore.collection("Vehicles").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                for (QueryDocumentSnapshot document : documents) {
                    if (document.getData().get("Email").equals(App.user.getEmail())) {
                        Vehicle vehicle = new Vehicle((String) document.getData().get("Email"),
                                (String) document.getData().get("Make"),
                                (String) document.getData().get("Model"),
                                (Integer) document.getData().get("Year"),
                                (String) document.getData().get("Color"),
                                (String) document.getData().get("Fuel_Type"),
                                (Integer) document.getData().get("Miles"),
                                (Integer) document.getData().get("Accidents"),
                                (Double) document.getData().get("Price"),
                                (String) document.getData().get("Additionl_Information"));
                        SellerViewController.observableList.add(vehicle);
                    }
                }
            } else {
                System.out.println("No data");
            }
        } catch (InterruptedException | ExecutionException ex) {
            
        }
    }
    
    public static void addVehicleToCollection(Vehicle vehicle) {
        DocumentReference docRef = App.fstore.collection("Vehicles").document(UUID.randomUUID().toString());
        Map<String, Object> data = new HashMap<>();
        data.put("Email", vehicle.getEmail());
        data.put("Make", vehicle.getMake());
        data.put("Model", vehicle.getModel());
        data.put("Year", vehicle.getYear());
        data.put("Color", vehicle.getColor());
        data.put("Fuel_Type", vehicle.getFuelType());
        data.put("Miles", vehicle.getMiles());
        data.put("Accidents", vehicle.getAccidents());
        data.put("Price", vehicle.getPrice());
        data.put("Additional_Information", vehicle.getAdditionalInformation());
        ApiFuture<WriteResult> result = docRef.set(data);
    }
    
}
