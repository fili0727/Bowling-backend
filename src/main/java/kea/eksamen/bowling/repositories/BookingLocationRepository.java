package kea.eksamen.bowling.repositories;

import kea.eksamen.bowling.entity.Activity;
import kea.eksamen.bowling.entity.BookingLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingLocationRepository extends JpaRepository<BookingLocation, Integer> {
    List<BookingLocation> findByActivity(Activity activity);
}
