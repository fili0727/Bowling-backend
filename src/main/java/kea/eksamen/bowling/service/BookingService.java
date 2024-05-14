package kea.eksamen.bowling.service;

import kea.eksamen.bowling.dto.BookingDto;
import kea.eksamen.bowling.entity.ActivityType;
import kea.eksamen.bowling.entity.Booking;
import kea.eksamen.bowling.entity.BookingLocation;
import kea.eksamen.bowling.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingLocationService bookingLocationService;

    public BookingService(BookingRepository bookingRepository, BookingLocationService bookingLocationService) {
        this.bookingRepository = bookingRepository;
        this.bookingLocationService = bookingLocationService;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBowlingBookings() {
        List<Booking> all = bookingRepository.findAll();
        all.removeIf(booking -> booking.getBookingLocation().getActivityType() != ActivityType.BOWLING);

        return all;
    }

    public List<Booking> getAirHockeyBookings() {
        List<Booking> all = bookingRepository.findAll();
        all.removeIf(booking -> booking.getBookingLocation().getActivityType() != ActivityType.AIRHOCKEY);

        return all;
    }

    public List<Booking> getDiningBookings() {
        List<Booking> all = bookingRepository.findAll();
        all.removeIf(booking -> booking.getBookingLocation().getActivityType() != ActivityType.DINING);

        return all;
    }

    public List<Booking> getBookingsByActivityAndDate(ActivityType activityType, LocalDate date) {
        List<Booking> all = bookingRepository.findAll();

        all.removeIf(booking -> booking.getBookingLocation().getActivityType() != activityType);
        List<Booking> test = all.stream().filter(booking -> booking.getBookingTime().toLocalDate().equals(date)).toList();


        return test;
    }

    public Booking createBooking(BookingDto booking) {
        Optional<BookingLocation> bookingLocation = bookingLocationService.getBookingLocationById(booking.BookingLocationId());
        Integer amountOfPeople = booking.amountOfPeople();
        LocalDateTime bookingTime = LocalDateTime.parse(booking.bookingTime());

        Booking newBooking = new Booking(bookingLocation.get(), amountOfPeople, bookingTime);

        bookingRepository.save(newBooking);

        return newBooking;
    }
}
