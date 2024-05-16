package kea.eksamen.bowling.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;


    private LocalDateTime startTime;


    private LocalDateTime endTime;



    public Schedule() {}

    public Schedule(Employee employee, LocalDateTime startTime, LocalDateTime endTime) {
        this.employee = employee;
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
