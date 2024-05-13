package kea.eksamen.bowling.service;

import kea.eksamen.bowling.entity.ActivityType;
import kea.eksamen.bowling.entity.Booking;
import kea.eksamen.bowling.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
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

}
