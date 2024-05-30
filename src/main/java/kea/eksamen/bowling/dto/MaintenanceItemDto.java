package kea.eksamen.bowling.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record MaintenanceItemDto(LocalDate date, LocalTime startTime, LocalTime endTime, Integer bookingLocationId) {}
