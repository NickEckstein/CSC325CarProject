package bcs.csc.car.api.firebase;

import bcs.csc.car.api.App;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Firebase Initialization Class
 * @author Brian Niski
 */
public class FirestoreContext {

    public Firestore firebase() {
        FileInputStream serviceAccount;
        FirebaseOptions options;
        try {
            serviceAccount = new FileInputStream(App.RESOURCES_PATH + "key.json");
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
            System.out.println("SUCCESSFULLY CONNECTED TO FIREBASE");
            serviceAccount.close();
        } catch (FileNotFoundException ex) {
            System.out.println("UNABLE TO CONNECT TO FIREBASE \"key.json\" DOES NOT EXIST");
        } catch (IOException ex) {
            System.out.println("FAILURE TO CONNECT TO FIREBASE");
        }
        return FirestoreClient.getFirestore();
    }

}
