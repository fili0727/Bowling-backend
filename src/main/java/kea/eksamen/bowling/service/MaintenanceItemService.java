package kea.eksamen.bowling.service;

import kea.eksamen.bowling.dto.MaintenanceItemDto;
import kea.eksamen.bowling.entity.BookingLocation;
import kea.eksamen.bowling.entity.MaintenanceItem;
import kea.eksamen.bowling.repositories.BookingLocationRepository;
import kea.eksamen.bowling.repositories.MaintenanceItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class MaintenanceItemService {
    private final MaintenanceItemRepository maintenanceItemRepository;
    private final BookingLocationRepository bookingLocationRepository;

    public MaintenanceItemService(MaintenanceItemRepository maintenanceItemRepository, BookingLocationRepository bookingLocationRepository) {
        this.maintenanceItemRepository = maintenanceItemRepository;
        this.bookingLocationRepository = bookingLocationRepository;
    }

    public MaintenanceItem createMaintenanceItem(MaintenanceItemDto maintenanceItem) {
        MaintenanceItem item = new MaintenanceItem();
        Optional<BookingLocation> location = bookingLocationRepository.findById(maintenanceItem.bookingLocationId());
        item.setDate(maintenanceItem.date());
        item.setStartTime(maintenanceItem.startTime());
        item.setEndTime(maintenanceItem.endTime());
        item.setBookingLocation(location.orElseThrow());


        return maintenanceItemRepository.save(item);
    }
}
