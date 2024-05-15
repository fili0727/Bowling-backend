package kea.eksamen.bowling.config;


import kea.eksamen.bowling.entity.Booking;
import kea.eksamen.bowling.entity.BookingLocation;
import kea.eksamen.bowling.entity.Product;
import kea.eksamen.bowling.entity.*;
import kea.eksamen.bowling.repositories.BookingLocationRepository;
import kea.eksamen.bowling.repositories.BookingRepository;
import kea.eksamen.bowling.repositories.OpeningHoursRepository;
import kea.eksamen.bowling.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class CreateTestData implements CommandLineRunner {

    private final BookingRepository bookingRepository;
    private final BookingLocationRepository bookingLocationRepository;
    private final ProductRepository productRepository;

    private final OpeningHoursRepository openingHoursRepository;

    public CreateTestData(BookingRepository bookingRepository, BookingLocationRepository bookingLocationRepository,
                          OpeningHoursRepository openingHoursRepository, ProductRepository productRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingLocationRepository = bookingLocationRepository;
        this.openingHoursRepository = openingHoursRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createOpeningHours();
        createBookingLocations();
        createBookings();
        createProducts();
    }

    private void createProducts() {
        Product product1 = new Product("https://www.poetzsch-padborg.dk/139-large_default/Coca-Cola-.jpg", "Coca Cola", 19.90);
        Product product2 = new Product("https://billigfadoel.dk/wp-content/uploads/2018/11/Fanta-Orange-33-cl-daase-24-stk-bestil-hos-Billigfadoel.png",  "Fanta", 19.90);
        Product product3 = new Product("https://potio.dk/wp-content/uploads/2022/02/tub-gron-oko.jpg", "Tuborg", 29.90);

        List<Product> products = List.of(product1, product2, product3);
        productRepository.saveAll(products);
    }


    private void createOpeningHours() {

        OpeningHours diningMonday = new OpeningHours( DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(22, 0), ActivityType.DINING);
        OpeningHours diningTuesday = new OpeningHours( DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(22, 0), ActivityType.DINING);
        OpeningHours diningWednesday = new OpeningHours( DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(22, 0), ActivityType.DINING);
        OpeningHours diningThursday = new OpeningHours( DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(22, 0), ActivityType.DINING);
        OpeningHours diningFriday = new OpeningHours( DayOfWeek.FRIDAY, LocalTime.of(10, 0), LocalTime.of(22, 0), ActivityType.DINING);
        OpeningHours diningSaturday = new OpeningHours( DayOfWeek.SATURDAY, LocalTime.of(10, 0), LocalTime.of(22, 0), ActivityType.DINING);
        OpeningHours diningSunday = new OpeningHours( DayOfWeek.SUNDAY, LocalTime.of(10, 0), LocalTime.of(22, 0), ActivityType.DINING);

        List<OpeningHours> openingHoursDining = List.of(diningMonday, diningTuesday, diningWednesday, diningThursday,
                diningFriday, diningSaturday, diningSunday);
        openingHoursRepository.saveAll(openingHoursDining);

        OpeningHours bowlingMonday = new OpeningHours( DayOfWeek.MONDAY, LocalTime.of(17, 0), LocalTime.of(21, 0), ActivityType.BOWLING);
        OpeningHours bowlingTuesday = new OpeningHours( DayOfWeek.TUESDAY, LocalTime.of(17, 0), LocalTime.of(21, 0), ActivityType.BOWLING);
        OpeningHours bowlingWednesday = new OpeningHours( DayOfWeek.WEDNESDAY, LocalTime.of(17, 0), LocalTime.of(21, 0), ActivityType.BOWLING);
        OpeningHours bowlingThursday = new OpeningHours( DayOfWeek.THURSDAY, LocalTime.of(17, 0), LocalTime.of(21, 0), ActivityType.BOWLING);
        OpeningHours bowlingFriday = new OpeningHours( DayOfWeek.FRIDAY, LocalTime.of(17, 0), LocalTime.of(23, 0), ActivityType.BOWLING);
        OpeningHours bowlingSaturday = new OpeningHours( DayOfWeek.SATURDAY, LocalTime.of(12, 0), LocalTime.of(23, 0), ActivityType.BOWLING);
        OpeningHours bowlingSunday = new OpeningHours( DayOfWeek.SUNDAY, LocalTime.of(12, 0), LocalTime.of(21, 0), ActivityType.BOWLING);

        List<OpeningHours> openingHoursBowling = List.of(bowlingMonday, bowlingTuesday, bowlingWednesday, bowlingThursday,
                bowlingFriday, bowlingSaturday, bowlingSunday);
        openingHoursRepository.saveAll(openingHoursBowling);

        OpeningHours airHockeyMonday = new OpeningHours( DayOfWeek.MONDAY, LocalTime.of(15, 0), LocalTime.of(21, 0), ActivityType.AIRHOCKEY);
        OpeningHours airHockeyTuesday = new OpeningHours( DayOfWeek.TUESDAY, LocalTime.of(15, 0), LocalTime.of(21, 0), ActivityType.AIRHOCKEY);
        OpeningHours airHockeyWednesday = new OpeningHours( DayOfWeek.WEDNESDAY, LocalTime.of(15, 0), LocalTime.of(21, 0), ActivityType.AIRHOCKEY);
        OpeningHours airHockeyThursday = new OpeningHours( DayOfWeek.THURSDAY, LocalTime.of(15, 0), LocalTime.of(21, 0), ActivityType.AIRHOCKEY);
        OpeningHours airHockeyFriday = new OpeningHours( DayOfWeek.FRIDAY, LocalTime.of(15, 0), LocalTime.of(23, 0), ActivityType.AIRHOCKEY);
        OpeningHours airHockeySaturday = new OpeningHours( DayOfWeek.SATURDAY, LocalTime.of(12, 0), LocalTime.of(23, 0), ActivityType.AIRHOCKEY);
        OpeningHours airHockeySunday = new OpeningHours( DayOfWeek.SUNDAY, LocalTime.of(12, 0), LocalTime.of(21, 0), ActivityType.AIRHOCKEY);

        List<OpeningHours> openingHoursAirHockey = List.of(airHockeyMonday, airHockeyTuesday, airHockeyWednesday, airHockeyThursday,
                airHockeyFriday, airHockeySaturday, airHockeySunday);
        openingHoursRepository.saveAll(openingHoursAirHockey);

    }



    private void createBookingLocations() {

        BookingLocation course1 = new BookingLocation(ActivityType.BOWLING,"Lane 1", 4);
        BookingLocation course2 = new BookingLocation(ActivityType.BOWLING,"Lane 2", 2);
        BookingLocation course3 = new BookingLocation(ActivityType.BOWLING,"Lane 3", 6);

        BookingLocation station1 = new BookingLocation(ActivityType.AIRHOCKEY,"Station 1", 4);
        BookingLocation station2 = new BookingLocation(ActivityType.AIRHOCKEY,"Station 2", 2);
        BookingLocation station3 = new BookingLocation(ActivityType.AIRHOCKEY,"Station 3", 6);

        BookingLocation table1 = new BookingLocation(ActivityType.DINING,"Table 1", 4);
        BookingLocation table2 = new BookingLocation(ActivityType.DINING,"Table 2", 2);
        BookingLocation table3 = new BookingLocation(ActivityType.DINING,"Table 3", 6);

        List<BookingLocation> bookingLocations = List.of(course1, course2, course3, station1, station2, station3, table1, table2, table3);
        bookingLocationRepository.saveAll(bookingLocations);
    }

    private void createBookings() {
        List<BookingLocation> bookingLocations = bookingLocationRepository.findAll();

        Booking booking1 = new Booking(bookingLocations.get(0), 4, LocalDateTime.of(2024, 5, 16, 18, 0), "Daniel Test");
        Booking booking2 = new Booking(bookingLocations.get(1), 2, LocalDateTime.of(2024, 5, 16, 18, 0), "Daniel Test");
        Booking booking3 = new Booking(bookingLocations.get(2), 6, LocalDateTime.of(2024, 5, 16, 18, 0), "Daniel Test");
        Booking booking4 = new Booking(bookingLocations.get(3), 4, LocalDateTime.of(2024, 5, 16, 17, 0), "Daniel Test");
        Booking booking5 = new Booking(bookingLocations.get(4), 2, LocalDateTime.of(2024, 5, 17, 17, 0), "Daniel Test");
        Booking booking6 = new Booking(bookingLocations.get(5), 6, LocalDateTime.of(2024, 5, 18, 18, 0), "Daniel Test");
        Booking booking7 = new Booking(bookingLocations.get(6), 4, LocalDateTime.of(2024, 5, 16, 18, 0), "Daniel Test");
        Booking booking8 = new Booking(bookingLocations.get(7), 2, LocalDateTime.of(2024, 5, 16, 18, 0), "Daniel Test");
        Booking booking9 = new Booking(bookingLocations.get(8), 6, LocalDateTime.of(2024, 5, 16, 18, 0), "Daniel Test");

        List<Booking> bookings = List.of(booking1, booking2, booking3, booking4, booking5, booking6, booking7, booking8, booking9);
        bookingRepository.saveAll(bookings);
    }
}
