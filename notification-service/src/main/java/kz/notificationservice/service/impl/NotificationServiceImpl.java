package kz.notificationservice.service.impl;

import kz.notificationservice.entity.NotificationEntity;
import kz.notificationservice.repository.NotificationRepository;
import kz.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationEntity sendNotification(String recipient, String message, String type) {
        // Create a new NotificationEntity
        NotificationEntity notification = new NotificationEntity();
        notification.setRecipient(recipient);
        notification.setMessage(message);
        notification.setType(type);
        notification.setStatus("PENDING");
        notification.setCreatedAt(LocalDateTime.now());
        notification.setUpdatedAt(LocalDateTime.now());

        // Here, add logic to send the actual notification (e.g., email or SMS)
        // For simplicity, let's assume it always succeeds
        notification.setStatus("SENT");

        // Save the notification to the database for record-keeping
        return notificationRepository.save(notification);
    }
}
