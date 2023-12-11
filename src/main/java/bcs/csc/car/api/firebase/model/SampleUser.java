package bcs.csc.car.api.firebase.model;

import bcs.csc.car.api.App;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Test Model Class
 * @author Bryant Velasquez
 */
public class SampleUser {

    private String email;
    private String password;

    public SampleUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Test method to add new user to Firebase collection
     * @param user 
     */
    public static void addUser(SampleUser user) {
        DocumentReference docRef = App.fstore.collection("Users").document(UUID.randomUUID().toString());
        Map<String, Object> data = new HashMap<>();
        data.put("Email", user.email);
        data.put("Password", user.password);
        ApiFuture<WriteResult> result = docRef.set(data);
    }

    /**
     * Test method to read users from Firebase collection
     * @return 
     */
    public static boolean readUsers() {
        boolean key = false;

        ApiFuture<QuerySnapshot> future = App.fstore.collection("Users").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                System.out.println("Outing data from firabase database....");
                for (QueryDocumentSnapshot document : documents) {
                    System.out.println(document.getId() + " => "
                            + document.getData().get("Email")
                            + " " + document.getData().get("Password")
                    );
                    System.out.println();
                }
            } else {
                System.out.println("No data");
            }
            key = true;

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        return key;
    }

}
