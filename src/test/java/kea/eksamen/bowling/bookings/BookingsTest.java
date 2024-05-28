package kea.eksamen.bowling.bookings;

import kea.eksamen.bowling.entity.Booking;
import kea.eksamen.bowling.entity.BookingLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingsTest {

    private Booking booking;

    @BeforeEach
    public void setUp() {
        BookingLocation bookingLocation = new BookingLocation();
        Integer amountOfPeople = 5;
        LocalDateTime bookingTime = LocalDateTime.now();
        String name = "Test Booking";

        booking = new Booking(bookingLocation, amountOfPeople, bookingTime, name);
    }

    @Test
    void testGetBookingLocation() {
        // ARRANGE
        BookingLocation bookingLocation = new BookingLocation();

        // ACT
        booking.setBookingLocation(bookingLocation);

        // ASSERT
        assertEquals(bookingLocation, booking.getBookingLocation());
    }

    @Test
    void testGetAmountOfPeople() {
        // ARRANGE
        Integer amountOfPeople = 5;

        // ACT
        booking.setAmountOfPeople(amountOfPeople);

        // ASSERT
        assertEquals(amountOfPeople, booking.getAmountOfPeople());
    }

    @Test
    void testGetBookingTime() {
        // ARRANGE
        LocalDateTime bookingTime = LocalDateTime.now();

        // ACT
        booking.setBookingTime(bookingTime);

        // ASSERT
        assertEquals(bookingTime, booking.getBookingTime());
    }

    @Test
    void testGetName() {
        // ARRANGE
        String name = "Test Booking";

        // ACT
        booking.setName(name);

        // ASSERT
        assertEquals(name, booking.getName());
    }
}
