package kz.bookingservice.controller;

import kz.bookingservice.entity.BookingEntity;
import kz.bookingservice.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingEntity> createBooking(@RequestParam Long restaurantId,
                                                 @RequestParam Long userId,
                                                 @RequestParam String bookingDateTime) {
        LocalDateTime dateTime = LocalDateTime.parse(bookingDateTime);
        BookingEntity booking = bookingService.createBooking(restaurantId, userId, dateTime);
        return ResponseEntity.ok(booking);
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<BookingEntity> confirmBooking(@PathVariable Long id) {
        return bookingService.confirmBooking(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<BookingEntity> cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<BookingEntity> getUserBookings(@PathVariable Long userId) {
        return bookingService.getUserBookings(userId);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<BookingEntity> getRestaurantBookings(@PathVariable Long restaurantId) {
        return bookingService.getRestaurantBookings(restaurantId);
    }
}
