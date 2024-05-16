package kea.eksamen.bowling.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private BookingLocation bookingLocation;

    private Integer amountOfPeople;
    private LocalDateTime bookingTime;
    private String name;

    public Booking(BookingLocation bookingLocation, Integer amountOfPeople, LocalDateTime bookingTime, String name) {
        this.bookingLocation = bookingLocation;
        this.amountOfPeople = amountOfPeople;
        this.bookingTime = bookingTime;
        this.name = name;
    }
}
