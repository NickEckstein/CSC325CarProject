package bcs.csc.car.api.firebase.utils;

import bcs.csc.car.api.App;
import static bcs.csc.car.api.App.users;
import static bcs.csc.car.api.App.vehicles;
import static bcs.csc.car.api.controller.NoLoginViewController.fullObservableList;
import bcs.csc.car.api.firebase.model.User;
import bcs.csc.car.api.firebase.model.Vehicle;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.HashMap;
import java.util.LinkedList;
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
        for (int i = 0; i < App.users.size(); i++) {
            if (email.equals(App.users.get(i).getEmail())) {
                return true;
            }
        }
        return false;
    }

    public static boolean scanCollectionForMatchingLogin(String email, String password) {
        for (int i = 0; i < App.users.size(); i++) {
            if ((email.equals(App.users.get(i).getEmail()) && password.equals(App.users.get(i).getPassword()))) {
                App.user = App.users.get(i);
                return true;
            }
        }
        return false;
    }

    public static String getSellerInformationFromEmail(String email) {
        for (int i = 0; i < App.users.size(); i++) {
            if (email.equals(App.users.get(i).getEmail())) {
                return "Name= " + App.users.get(i).getFirstName() + " " + App.users.get(i).getLastName() + "\n"
                        + "Email= " + App.users.get(i).getEmail() + "\n"
                        + "Phone Number= " + App.users.get(i).getPhoneNumber() + "\n"
                        + "Address= " + App.users.get(i).getAddress();
            }
        }
        return "";
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

    public static void addVehicleToCollection(Vehicle vehicle) {
        DocumentReference docRef = App.fstore.collection("Vehicles").document(UUID.randomUUID().toString());
        Map<String, Object> data = new HashMap<>();
        data.put("Email", vehicle.getEmail());
        data.put("Make", vehicle.getMake());
        data.put("Model", vehicle.getModel());
        data.put("Year", String.valueOf(vehicle.getYear()));
        data.put("Color", vehicle.getColor());
        data.put("FuelType", vehicle.getFuelType());
        data.put("Miles", String.valueOf(vehicle.getMiles()));
        data.put("Accidents", String.valueOf(vehicle.getAccidents()));
        data.put("Price", String.valueOf(vehicle.getPrice()));
        data.put("Additional_Information", vehicle.getAdditionalInformation());
        ApiFuture<WriteResult> result = docRef.set(data);
    }

    public static void refreshCollection() {
        fullObservableList.clear();
        //tableView.getItems().clear();
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
