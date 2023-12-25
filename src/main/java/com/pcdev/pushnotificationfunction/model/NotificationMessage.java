package com.pcdev.pushnotificationfunction.model;

import lombok.Data;

@Data
public class NotificationMessage {
    private String title;
    private String body;
    private String iconUrl;
}
