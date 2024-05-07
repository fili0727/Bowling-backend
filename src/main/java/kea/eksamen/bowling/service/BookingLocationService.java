package kea.eksamen.bowling.service;

import kea.eksamen.bowling.entity.Activity;
import kea.eksamen.bowling.entity.BookingLocation;
import kea.eksamen.bowling.repositories.BookingLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingLocationService {
    private final BookingLocationRepository bookingLocationRepository;

    public BookingLocationService(BookingLocationRepository bookingLocationRepository) {
        this.bookingLocationRepository = bookingLocationRepository;
    }

    public List<BookingLocation> getAllBookingLocations() {
        return bookingLocationRepository.findAll();
    }

    public List<BookingLocation> getAllTables() {
        return bookingLocationRepository.findByActivity(Activity.DINING);
    }

    public List<BookingLocation> getAllBowlingLanes() {
        return bookingLocationRepository.findByActivity(Activity.BOWLING);
    }

    public List<BookingLocation> getAllAirHockeyTables() {
        return bookingLocationRepository.findByActivity(Activity.AIRHOCKEY);
    }
}
