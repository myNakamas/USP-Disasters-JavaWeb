package json;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class FirebaseConfig {
    public static void Config() throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("json/serviceAcoountKey");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://example-ab923-default-rtdb.europe-west1.firebasedatabase.app")
                .build();

        FirebaseApp.initializeApp(options);

    }
}
