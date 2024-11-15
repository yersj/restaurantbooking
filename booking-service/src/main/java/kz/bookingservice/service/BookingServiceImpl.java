package kz.bookingservice.service;

import kz.bookingservice.entity.BookingEntity;
import kz.bookingservice.common.BookingStatus;
import kz.bookingservice.repository.BookingRepository;
import kz.bookingservice.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingEntity createBooking(Long restaurantId, Long userId, LocalDateTime bookingDateTime) {
        BookingEntity booking = new BookingEntity();
        booking.setRestaurantId(restaurantId);
        booking.setUserId(userId);
        booking.setBookingDateTime(bookingDateTime);
        booking.setStatus(BookingStatus.PENDING);
        booking.setCreatedAt(LocalDateTime.now());
        booking.setUpdatedAt(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<BookingEntity> confirmBooking(Long bookingId) {
        return updateBookingStatus(bookingId, BookingStatus.CONFIRMED);
    }

    @Override
    public Optional<BookingEntity> cancelBooking(Long bookingId) {
        return updateBookingStatus(bookingId, BookingStatus.CANCELLED);
    }

    private Optional<BookingEntity> updateBookingStatus(Long bookingId, BookingStatus status) {
        return bookingRepository.findById(bookingId)
                .map(booking -> {
                    booking.setStatus(status);
                    booking.setUpdatedAt(LocalDateTime.now());
                    return bookingRepository.save(booking);
                });
    }

    @Override
    public List<BookingEntity> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public List<BookingEntity> getRestaurantBookings(Long restaurantId) {
        return bookingRepository.findByRestaurantId(restaurantId);
    }
}

