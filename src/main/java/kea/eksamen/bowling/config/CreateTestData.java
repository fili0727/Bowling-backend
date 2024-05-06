package kea.eksamen.bowling.config;

import kea.eksamen.bowling.entity.Activity;
import kea.eksamen.bowling.entity.Booking;
import kea.eksamen.bowling.entity.BookingLocation;
import kea.eksamen.bowling.repositories.BookingLocationRepository;
import kea.eksamen.bowling.repositories.BookingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CreateTestData implements CommandLineRunner {

    private final BookingRepository bookingRepository;
    private final BookingLocationRepository bookingLocationRepository;

    public CreateTestData(BookingRepository bookingRepository, BookingLocationRepository bookingLocationRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingLocationRepository = bookingLocationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createBookingLocations();
        createBookings();
    }

    private void createBookingLocations() {
        BookingLocation course1 = new BookingLocation(Activity.BOWLING,"Lane 1");
        BookingLocation course2 = new BookingLocation(Activity.BOWLING,"Lane 2");
        BookingLocation course3 = new BookingLocation(Activity.BOWLING,"Lane 3");

        BookingLocation station1 = new BookingLocation(Activity.AIRHOCKEY,"Station 1");
        BookingLocation station2 = new BookingLocation(Activity.AIRHOCKEY,"Station 2");
        BookingLocation station3 = new BookingLocation(Activity.AIRHOCKEY,"Station 3");

        BookingLocation table1 = new BookingLocation(Activity.DINING,"Table 1");
        BookingLocation table2 = new BookingLocation(Activity.DINING,"Table 2");
        BookingLocation table3 = new BookingLocation(Activity.DINING,"Table 3");

        List<BookingLocation> bookingLocations = List.of(course1, course2, course3, station1, station2, station3, table1, table2, table3);
        bookingLocationRepository.saveAll(bookingLocations);
    }

    private void createBookings() {
        List<BookingLocation> bookingLocations = bookingLocationRepository.findAll();

        Booking booking1 = new Booking(bookingLocations.get(0), 4, LocalDateTime.of(2024, 5, 10, 18, 0));
        Booking booking2 = new Booking(bookingLocations.get(1), 2, LocalDateTime.of(2024, 5, 10, 18, 0));
        Booking booking3 = new Booking(bookingLocations.get(2), 6, LocalDateTime.of(2024, 5, 10, 18, 0));
        Booking booking4 = new Booking(bookingLocations.get(3), 4, LocalDateTime.of(2024, 5, 10, 18, 0));
        Booking booking5 = new Booking(bookingLocations.get(4), 2, LocalDateTime.of(2024, 5, 10, 18, 0));
        Booking booking6 = new Booking(bookingLocations.get(5), 6, LocalDateTime.of(2024, 5, 10, 18, 0));
        Booking booking7 = new Booking(bookingLocations.get(6), 4, LocalDateTime.of(2024, 5, 10, 18, 0));
        Booking booking8 = new Booking(bookingLocations.get(7), 2, LocalDateTime.of(2024, 5, 10, 18, 0));
        Booking booking9 = new Booking(bookingLocations.get(8), 6, LocalDateTime.of(2024, 5, 10, 18, 0));

        List<Booking> bookings = List.of(booking1, booking2, booking3, booking4, booking5, booking6, booking7, booking8, booking9);
        bookingRepository.saveAll(bookings);
    }
}
