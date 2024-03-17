package com.fastvan.fastvandemoapi.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class NotificationPayload {
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNo;
    private Map<String, Object> additionalData;
}
