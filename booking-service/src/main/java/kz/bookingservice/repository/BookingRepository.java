package kz.bookingservice.repository;



import kz.bookingservice.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findByUserId(Long userId);
    List<BookingEntity> findByRestaurantId(Long restaurantId);
}

