package kea.eksamen.bowling.repositories;

import kea.eksamen.bowling.entity.BookingLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingLocationRepository extends JpaRepository<BookingLocation, Integer> {
}
