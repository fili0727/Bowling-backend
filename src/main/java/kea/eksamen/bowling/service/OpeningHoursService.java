package kea.eksamen.bowling.service;

import kea.eksamen.bowling.entity.ActivityType;
import kea.eksamen.bowling.entity.OpeningHours;
import kea.eksamen.bowling.repositories.OpeningHoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpeningHoursService {
    private final OpeningHoursRepository openingHoursRepository;

    public OpeningHoursService(OpeningHoursRepository openingHoursRepository) {
        this.openingHoursRepository = openingHoursRepository;
    }

    public List<OpeningHours> getAllOpeningHours() {
        return openingHoursRepository.findAll();
    }

    public List<OpeningHours> getOpeningHoursDining() {
        return openingHoursRepository.findByActivityType(ActivityType.DINING);
    }

    public List<OpeningHours> getOpeningHoursBowling() {
        return openingHoursRepository.findByActivityType(ActivityType.BOWLING);
    }

    public List<OpeningHours> getOpeningHoursAirHockey() {
        return openingHoursRepository.findByActivityType(ActivityType.AIRHOCKEY);
    }
}
