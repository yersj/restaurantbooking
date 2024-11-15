package kz.bookingservice.service;

import kz.bookingservice.entity.BookingEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingService {

    BookingEntity createBooking(Long restaurantId, Long userId, LocalDateTime bookingDateTime);

    Optional<BookingEntity> confirmBooking(Long bookingId);

    Optional<BookingEntity> cancelBooking(Long bookingId);

    List<BookingEntity> getUserBookings(Long userId);

    List<BookingEntity> getRestaurantBookings(Long restaurantId);
}

