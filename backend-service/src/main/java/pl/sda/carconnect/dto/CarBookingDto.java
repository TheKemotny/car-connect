package pl.sda.carconnect.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CarBookingDto(
        Long id,
        CarDto bookedCar,
        ClientDto client,
        LocalDate startDate,
        LocalDate returnDate,
        long totalPriceInPolishGrosz,
        AddressDto startLocation,
        AddressDto finalLocation,
        LocalDateTime creationTimestamp,
        LocalDateTime lastUpdateTimestamp
) {
}
