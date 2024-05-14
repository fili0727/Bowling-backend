// BookingLocationRepository.java
package kea.eksamen.bowling.repositories;

import kea.eksamen.bowling.entity.ActivityType;
import kea.eksamen.bowling.entity.BookingLocation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BookingLocationRepository extends JpaRepository<BookingLocation, Integer> {
    List<BookingLocation> findByActivityType(ActivityType activityType);
}
