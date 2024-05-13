package kea.eksamen.bowling.controller;

import kea.eksamen.bowling.entity.ActivityType;
import kea.eksamen.bowling.entity.Booking;
import kea.eksamen.bowling.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @RequestMapping("/bowling")
    public List<Booking> getBowlingBookings() {
        return bookingService.getBowlingBookings();
    }

    @RequestMapping("/airhockey")
    public List<Booking> getAirHockeyBookings() {
        return bookingService.getAirHockeyBookings();
    }

    @RequestMapping("/dining")
    public List<Booking> getDiningBookings() {
        return bookingService.getDiningBookings();
    }

    @RequestMapping("/activityAndDate")
    public List<Booking> getBookingsByActivityAndDate(@RequestParam ActivityType activityType, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return bookingService.getBookingsByActivityAndDate(activityType, date);
    }
}
