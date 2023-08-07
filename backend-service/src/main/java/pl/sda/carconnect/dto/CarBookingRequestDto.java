package pl.sda.carconnect.dto;

import java.time.LocalDate;

public record CarBookingRequestDto(
        Long bookedCarId,
        Long clientId,
        LocalDate startDate,
        LocalDate returnDate,
        Long startLocationId,
        Long finalLocationId
) {
}