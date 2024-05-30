package kea.eksamen.bowling.controller;

import kea.eksamen.bowling.dto.MaintenanceItemDto;
import kea.eksamen.bowling.entity.MaintenanceItem;
import kea.eksamen.bowling.service.MaintenanceItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceItemController {
    private final MaintenanceItemService maintenanceItemService;

    public MaintenanceItemController(MaintenanceItemService maintenanceItemService) {
        this.maintenanceItemService = maintenanceItemService;
    }

    @PostMapping
    public ResponseEntity<MaintenanceItem> createMaintenanceItem(@RequestBody MaintenanceItemDto maintenanceItem) {
        System.out.println(maintenanceItem);
        return ResponseEntity.ok(maintenanceItemService.createMaintenanceItem(maintenanceItem));
    }
}
