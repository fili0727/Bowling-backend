package kea.eksamen.bowling.controller;

import kea.eksamen.bowling.entity.Booking;
import kea.eksamen.bowling.service.BookingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
