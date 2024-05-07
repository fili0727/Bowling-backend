package kea.eksamen.bowling.entity;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private Activity activity;

    private String name;

    private Integer capacity;

    public BookingLocation(Activity activity, String name, Integer capacity) {
        this.activity = activity;
        this.name = name;
        this.capacity = capacity;
    }
}
