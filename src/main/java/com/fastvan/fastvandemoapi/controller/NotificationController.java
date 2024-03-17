package com.fastvan.fastvandemoapi.controller;


import com.fastvan.fastvandemoapi.model.CreateNotificationRequest;
import com.fastvan.fastvandemoapi.model.NotificationPayload;
import com.fastvan.fastvandemoapi.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping(path = "notification")
    public ResponseEntity<String> sendTestNotification(@RequestBody NotificationPayload request){
        notificationService.sendEmailNotification(request);
        return new ResponseEntity<>("Notification send successfully", HttpStatus.OK);
    }

    @PostMapping(path = "notification/bulk")
    public ResponseEntity<String> sendTestNotification(@RequestBody CreateNotificationRequest request){
        notificationService.sendEmailNotificationBulk(request);
        return new ResponseEntity<>("Notification send successfully", HttpStatus.OK);
    }
}
