package kea.eksamen.bowling.controller;

import kea.eksamen.bowling.entity.BookingLocation;
import kea.eksamen.bowling.service.BookingLocationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookingLocations")
public class BookingLocationController {
    private final BookingLocationService bookingLocationService;

    public BookingLocationController(BookingLocationService bookingLocationService) {
        this.bookingLocationService = bookingLocationService;
    }

    @RequestMapping
    public List<BookingLocation> getAllBookingLocations() {
        return bookingLocationService.getAllBookingLocations();
    }

    @RequestMapping("/tables")
    public List<BookingLocation> getAllTables() {
        return bookingLocationService.getAllTables();
    }

}
