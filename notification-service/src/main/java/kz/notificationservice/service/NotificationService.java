package kz.notificationservice.service;

import kz.notificationservice.entity.NotificationEntity;

public interface NotificationService {
    NotificationEntity sendNotification(String recipient, String message, String type);
}
