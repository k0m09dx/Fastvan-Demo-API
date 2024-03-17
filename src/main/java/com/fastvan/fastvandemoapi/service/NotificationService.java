package com.fastvan.fastvandemoapi.service;

import com.fastvan.fastvandemoapi.model.CreateNotificationRequest;
import com.fastvan.fastvandemoapi.model.NotificationPayload;

public interface NotificationService {
    void sendEmailNotification(NotificationPayload payload);
    void sendEmailNotificationBulk(CreateNotificationRequest payload);
    void createWorkflow();
}
