package kea.eksamen.bowling.service;

import kea.eksamen.bowling.entity.ActivityType;
import kea.eksamen.bowling.entity.BookingLocation;
import kea.eksamen.bowling.repositories.BookingLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingLocationService {
    private final BookingLocationRepository bookingLocationRepository;

    public BookingLocationService(BookingLocationRepository bookingLocationRepository) {
        this.bookingLocationRepository = bookingLocationRepository;
    }

    public Optional<BookingLocation> getBookingLocationById(int id) {
        return bookingLocationRepository.findById(id);
    }

    public List<BookingLocation> getAllBookingLocations() {
        return bookingLocationRepository.findAll();
    }

    public List<BookingLocation> getAllTables() {
        System.out.println(bookingLocationRepository.findByActivityType(ActivityType.DINING));
        return bookingLocationRepository.findByActivityType(ActivityType.DINING);
    }

    public List<BookingLocation> getAllBowlingLanes() {
        return bookingLocationRepository.findByActivityType(ActivityType.BOWLING);
    }

    public List<BookingLocation> getAllAirHockeyTables() {
        return bookingLocationRepository.findByActivityType(ActivityType.AIRHOCKEY);
    }
}
