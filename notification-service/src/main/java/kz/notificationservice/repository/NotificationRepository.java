package kz.notificationservice.repository;

import kz.notificationservice.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    // Additional query methods (if needed) can be added here
}
