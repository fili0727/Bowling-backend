package kea.eksamen.bowling.controller;

import kea.eksamen.bowling.dto.BookingDto;
import kea.eksamen.bowling.dto.BookingEditDto;
import kea.eksamen.bowling.entity.ActivityType;
import kea.eksamen.bowling.entity.Booking;
import kea.eksamen.bowling.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/bowling")
    public List<Booking> getBowlingBookings() {
        return bookingService.getBowlingBookings();
    }

    @GetMapping("/airhockey")
    public List<Booking> getAirHockeyBookings() {
        return bookingService.getAirHockeyBookings();
    }

    @GetMapping("/dining")
    public List<Booking> getDiningBookings() {
        return bookingService.getDiningBookings();
    }

    @GetMapping("/activityAndDate")
    public List<Booking> getBookingsByActivityAndDate(@RequestParam ActivityType activityType, @RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy", iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return bookingService.getBookingsByActivityAndDate(activityType, date);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDto booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int id, @RequestBody BookingEditDto booking) {
        return ResponseEntity.ok(bookingService.updateBooking(id, booking));
    }
}
