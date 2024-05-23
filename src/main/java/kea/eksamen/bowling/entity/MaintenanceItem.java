package kea.eksamen.bowling.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MaintenanceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    @ManyToOne
    private BookingLocation bookingLocation;

    private LocalTime startTime;
    private LocalTime endTime;

    public MaintenanceItem(LocalDate date, BookingLocation bookingLocation, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.bookingLocation = bookingLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
