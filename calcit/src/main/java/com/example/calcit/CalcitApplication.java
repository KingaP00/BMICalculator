package com.example.calcit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class CalcitApplication {

		public static void main(String[] args) {

		try {
			connectToFirebase();
		} catch (IOException e) {
			System.out.println("Couldn't connect to firebase!");
		}
		

		SpringApplication.run(CalcitApplication.class, args);
	}

	private static void connectToFirebase() throws IOException{
		ClassLoader classLoader = CalcitApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = new FirebaseOptions.Builder()
  			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
  			.build();

		FirebaseApp.initializeApp(options);
	}

}
