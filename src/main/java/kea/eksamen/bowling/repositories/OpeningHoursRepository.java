package kea.eksamen.bowling.repositories;

import kea.eksamen.bowling.entity.ActivityType;
import kea.eksamen.bowling.entity.OpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Integer> {
    List<OpeningHours> findByActivityType(ActivityType activityType);
}
