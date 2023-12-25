package com.pcdev.pushnotificationfunction;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.io.IOException;


@SpringBootApplication
public class PushNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PushNotificationApplication.class, args);
    }
}