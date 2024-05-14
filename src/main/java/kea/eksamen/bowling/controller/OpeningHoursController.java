package kea.eksamen.bowling.controller;

import kea.eksamen.bowling.entity.OpeningHours;
import kea.eksamen.bowling.service.OpeningHoursService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/openingHours")
public class OpeningHoursController {
    private final OpeningHoursService openingHoursService;

    public OpeningHoursController(OpeningHoursService openingHoursService) {
        this.openingHoursService = openingHoursService;
    }

    @RequestMapping
    public List<OpeningHours> getAllOpeningHours() {
        return openingHoursService.getAllOpeningHours();
    }

    @RequestMapping("/dining")
    public List<OpeningHours> getOpeningHoursDining() {
        return openingHoursService.getOpeningHoursDining();
    }

    @RequestMapping("/bowling")
    public List<OpeningHours> getOpeningHoursBowling() {
        return openingHoursService.getOpeningHoursBowling();
    }

    @RequestMapping("/airhockey")
    public List<OpeningHours> getOpeningHoursAirHockey() {
        return openingHoursService.getOpeningHoursAirHockey();
    }
}
