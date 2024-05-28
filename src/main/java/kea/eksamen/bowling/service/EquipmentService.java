package kea.eksamen.bowling.service;

import kea.eksamen.bowling.dto.EquipmentStockDTO;
import kea.eksamen.bowling.dto.ProductPriceDTO;
import kea.eksamen.bowling.entity.Product;
import kea.eksamen.bowling.repositories.EquipmentRepository;
import kea.eksamen.bowling.entity.Equipment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }


    public Equipment addEquipment(Equipment equipment){
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipmentStock(int id, EquipmentStockDTO equipmentStockDTO) {
        Equipment equipmentStockToUpdate = equipmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        equipmentStockToUpdate.setStock(equipmentStockDTO.stock());
        equipmentRepository.save(equipmentStockToUpdate);
        return equipmentStockToUpdate;
    }





}
