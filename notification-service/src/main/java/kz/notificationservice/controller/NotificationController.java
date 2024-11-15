package kz.notificationservice.controller;

import kz.notificationservice.entity.NotificationEntity;
import kz.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Endpoint for sending a notification
    @PostMapping("/send")
    public ResponseEntity<NotificationEntity> sendNotification(
            @RequestParam String recipient,
            @RequestParam String message,
            @RequestParam String type) {

        NotificationEntity notification = notificationService.sendNotification(recipient, message, type);
        return new ResponseEntity<>(notification, HttpStatus.CREATED);
    }
}
