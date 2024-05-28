package kea.eksamen.bowling.controller;

import kea.eksamen.bowling.dto.EquipmentStockDTO;
import kea.eksamen.bowling.entity.Equipment;
import kea.eksamen.bowling.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentService.addEquipment(equipment);
    }

    @PatchMapping("/{id}")
    public Equipment updateEquipmentStock(@PathVariable int id, @RequestBody EquipmentStockDTO equipmentStockDTO) {
        return equipmentService.updateEquipmentStock(id, equipmentStockDTO);
    }


}
