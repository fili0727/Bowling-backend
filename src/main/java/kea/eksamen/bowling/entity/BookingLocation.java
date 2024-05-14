package kea.eksamen.bowling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BookingLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    public BookingLocation(ActivityType activityType, String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
        this.activityType = activityType;
    }
}
