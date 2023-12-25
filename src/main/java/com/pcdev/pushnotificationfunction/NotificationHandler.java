package com.pcdev.pushnotificationfunction;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


public class NotificationHandler {

    private static final FirebaseApp app;

    static {

        GoogleCredentials googleCredentials;
        try {
            googleCredentials = GoogleCredentials
                    .fromStream(new ClassPathResource("serviceAccountKey.json").getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .build();

        System.out.println("Firebase App Successfully Initialized");
        app = FirebaseApp.initializeApp(firebaseOptions);
    }

    public void handleRequest() {

        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance(app);

        Notification notification = Notification.builder()
                .setTitle("Spendwise")
                .setBody("Don't forget to track today's expenses! Every penny counts. Tap here to add them now")
                .build();

        Message message = Message.builder()
                .setNotification(notification)
                .setTopic("DailyExpenseReminder")
                .build();

        try {
            String messageId = firebaseMessaging.send(message);
            System.out.println("Sent message with id: " + messageId);
        } catch (Exception e) {
            System.out.println("Something went wrong in sending push notification: " + e.getMessage());
        }
    }


}
