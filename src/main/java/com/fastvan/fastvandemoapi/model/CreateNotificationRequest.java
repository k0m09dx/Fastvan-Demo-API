package com.fastvan.fastvandemoapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateNotificationRequest {
    private List<NotificationPayload> notificationPayload;
}
