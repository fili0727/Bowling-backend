package kea.eksamen.bowling.repositories;

import kea.eksamen.bowling.entity.MaintenanceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceItemRepository extends JpaRepository<MaintenanceItem, Integer> {
}
