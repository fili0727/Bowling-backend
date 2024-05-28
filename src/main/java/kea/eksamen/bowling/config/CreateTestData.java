package kea.eksamen.bowling.config;


import kea.eksamen.bowling.entity.Booking;
import kea.eksamen.bowling.entity.BookingLocation;
import kea.eksamen.bowling.entity.Product;
import kea.eksamen.bowling.entity.*;
import kea.eksamen.bowling.repositories.*;
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
    private final ScheduleRepository scheduleRepository;
    private final OpeningHoursRepository openingHoursRepository;
    private final EmployeeRepository employeeRepository;
    private final EquipmentRepository equipmentRepository;

    public CreateTestData(BookingRepository bookingRepository, BookingLocationRepository bookingLocationRepository,
                          OpeningHoursRepository openingHoursRepository, ProductRepository productRepository, ScheduleRepository scheduleRepository, EmployeeRepository employeeRepository, EquipmentRepository equipmentRepository){
        this.bookingRepository = bookingRepository;
        this.bookingLocationRepository = bookingLocationRepository;
        this.openingHoursRepository = openingHoursRepository;
        this.productRepository = productRepository;
        this.scheduleRepository = scheduleRepository;
        this.employeeRepository = employeeRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createOpeningHours();
        createBookingLocations();
        createBookings();
        createProducts();
        createEmployees();
        createEquipment();
    }

    private void createEquipment(){
        Equipment equipment1 = new Equipment("Bowling Ball", "https://bowlingshopdanmark.dk/wp-content/uploads/2020/09/A4885F08-0B59-41DC-BA3B-D5E2EAA1A42E.png", 19, "https://bowlingshopdanmark.dk/product/melee-jab-blood-red/");
        Equipment equipment2 = new Equipment("Bowling Shoes","https://bowlingshopdanmark.dk/wp-content/uploads/2022/10/CFB042D3-BD53-4EF1-8F65-DD7876DC916C.png", 47, "https://bowlingshopdanmark.dk/product/3g-belmo-tour-gold/");
        Equipment equipment3 = new Equipment("Air Hockey Puck","https://legebyen.dk/cdn/shop/products/7129606_prod_1_700x.jpg?v=1653702220", 23, "https://legebyen.dk/products/air-hockey-puck-3-stk-original-o-50-mm?gad_source=1&gclid=Cj0KCQjw3tCyBhDBARIsAEY0XNmgKWV165Xgj1oo9sxbMm79TAGLMaL0De6LfqaW8FAWFHUwmbueZd8aAuadEALw_wcB");
        Equipment equipment4 = new Equipment("Air Hockey Mallet", "https://legebyen.dk/cdn/shop/products/7129610_prod_1_1000x.jpg?v=1653701552", 17,"https://legebyen.dk/products/airhockey-handtag-2-stk-de-luxe-96-mm?pr_prod_strat=jac&pr_rec_id=402562a8c&pr_rec_pid=7709300228317&pr_ref_pid=7709300162781&pr_seq=uniform");
        Equipment equipment5 = new Equipment("Brooms", "https://productimages.biltema.com/v1/image/imagebyfilename/47-0328_xl_1.jpg", 5,"https://www.biltema.dk/en-dk/home/cleaning/brushes/broom-and-dustpan-2000044232");
        Equipment equipment6 = new Equipment("Screws (packs)", "https://productimages.biltema.com/v1/image/imagebyfilename/87-0271_xl_1.jpg", 3,"https://www.biltema.dk/en-dk/construction/fixing-elements/wood-screws/screws-outdoor-320-parts-2000034557");


        List<Equipment> equipment = List.of(equipment1, equipment2, equipment3, equipment4, equipment5, equipment6);
        equipmentRepository.saveAll(equipment);
    }

    private void createEmployees() {
        // Create employees
        Employee manager1 = new Employee("John Doe", "Manager");
        Employee manager2 = new Employee("Emily White", "Manager");
        Employee manager3 = new Employee("Paul Green", "Manager");

        Employee cleaner1 = new Employee("Jane Smith", "Cleaning Staff");
        Employee cleaner2 = new Employee("Alice Brown", "Cleaning Staff");
        Employee cleaner3 = new Employee("Mike Davis", "Cleaning Staff");

        Employee cashier1 = new Employee("Bob Johnson", "Cashier");
        Employee cashier2 = new Employee("Lucy Brown", "Cashier");
        Employee cashier3 = new Employee("Tom Clark", "Cashier");

        Employee operator1 = new Employee("Alice Green", "Operator");
        Employee operator2 = new Employee("Chris Brown", "Operator");
        Employee operator3 = new Employee("Anna Wilson", "Operator");

        List<Employee> employees = List.of(manager1, manager2, manager3,
                cleaner1, cleaner2, cleaner3,
                cashier1, cashier2, cashier3,
                operator1, operator2, operator3);

        employeeRepository.saveAll(employees);

        // Create schedules
        Schedule schedule1 = new Schedule(manager1, LocalDateTime.of(2024, 5, 16, 10, 0), LocalDateTime.of(2024, 5, 16, 14, 0));
        Schedule schedule2 = new Schedule(manager2, LocalDateTime.of(2024, 5, 16, 14, 0), LocalDateTime.of(2024, 5, 16, 18, 0));
        Schedule schedule3 = new Schedule(manager3, LocalDateTime.of(2024, 5, 16, 18, 0), LocalDateTime.of(2024, 5, 16, 22, 0));

        Schedule schedule4 = new Schedule(cleaner1, LocalDateTime.of(2024, 5, 16, 10, 0), LocalDateTime.of(2024, 5, 16, 14, 0));
        Schedule schedule5 = new Schedule(cleaner2, LocalDateTime.of(2024, 5, 16, 14, 0), LocalDateTime.of(2024, 5, 16, 18, 0));
        Schedule schedule6 = new Schedule(cleaner3, LocalDateTime.of(2024, 5, 16, 18, 0), LocalDateTime.of(2024, 5, 16, 22, 0));

        Schedule schedule7 = new Schedule(cashier1, LocalDateTime.of(2024, 5, 16, 10, 0), LocalDateTime.of(2024, 5, 16, 14, 0));
        Schedule schedule8 = new Schedule(cashier2, LocalDateTime.of(2024, 5, 16, 14, 0), LocalDateTime.of(2024, 5, 16, 18, 0));
        Schedule schedule9 = new Schedule(cashier3, LocalDateTime.of(2024, 5, 16, 18, 0), LocalDateTime.of(2024, 5, 16, 22, 0));

        Schedule schedule10 = new Schedule(operator1, LocalDateTime.of(2024, 5, 16, 10, 0), LocalDateTime.of(2024, 5, 16, 14, 0));
        Schedule schedule11 = new Schedule(operator2, LocalDateTime.of(2024, 5, 16, 14, 0), LocalDateTime.of(2024, 5, 16, 18, 0));
        Schedule schedule12 = new Schedule(operator3, LocalDateTime.of(2024, 5, 16, 18, 0), LocalDateTime.of(2024, 5, 16, 22, 0));

        List<Schedule> schedules = List.of(schedule1, schedule2, schedule3,
                schedule4, schedule5, schedule6,
                schedule7, schedule8, schedule9,
                schedule10, schedule11, schedule12);

        scheduleRepository.saveAll(schedules);
    }


    private void createProducts() {
        Product product1 = new Product("https://www.poetzsch-padborg.dk/139-large_default/Coca-Cola-.jpg", "Coca Cola", 20);
        Product product2 = new Product("https://billigfadoel.dk/wp-content/uploads/2018/11/Fanta-Orange-33-cl-daase-24-stk-bestil-hos-Billigfadoel.png",  "Fanta", 20);
        Product product3 = new Product("https://potio.dk/wp-content/uploads/2022/02/tub-gron-oko.jpg", "Tuborg", 20);

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

        Booking booking1 = new Booking(bookingLocations.get(0), 4, LocalDateTime.of(2024, 5, 16, 18, 0), "Karen Kristensen");
        Booking booking2 = new Booking(bookingLocations.get(1), 2, LocalDateTime.of(2024, 5, 16, 18, 0), "Michael Jensen");
        Booking booking3 = new Booking(bookingLocations.get(2), 6, LocalDateTime.of(2024, 5, 16, 18, 0), "Daniel Larsen");
        Booking booking4 = new Booking(bookingLocations.get(3), 4, LocalDateTime.of(2024, 5, 25, 18, 0), "Thomas Aslan");
        Booking booking5 = new Booking(bookingLocations.get(4), 2, LocalDateTime.of(2024, 5, 26, 16, 0), "Morten Karlsen");
        Booking booking6 = new Booking(bookingLocations.get(5), 6, LocalDateTime.of(2024, 5, 27, 17, 0), "Nikoline Mogensen");
        Booking booking7 = new Booking(bookingLocations.get(6), 4, LocalDateTime.of(2024, 5, 16, 18, 0), "Sabrina Carpenter");
        Booking booking8 = new Booking(bookingLocations.get(7), 2, LocalDateTime.of(2024, 5, 16, 18, 0), "Taylor Swift");
        Booking booking9 = new Booking(bookingLocations.get(8), 6, LocalDateTime.of(2024, 5, 16, 18, 0), "Michael Jordan");

        List<Booking> bookings = List.of(booking1, booking2, booking3, booking4, booking5, booking6, booking7, booking8, booking9);
        bookingRepository.saveAll(bookings);
    }
}
