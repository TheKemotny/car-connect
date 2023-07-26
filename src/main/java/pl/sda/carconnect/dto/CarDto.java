package pl.sda.carconnect.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import pl.sda.carconnect.domain.enumeration.BodyType;
import pl.sda.carconnect.domain.enumeration.EngineType;
import pl.sda.carconnect.domain.enumeration.FuelType;

@Builder
public record CarDto(
        Long id,
        @NotNull
        @Size(min = 2)
        String model,
        @NotNull
        @Size(min = 2)
        String brand,
        @NotNull
        FuelType fuelType,
        @NotNull
        EngineType engineType,
        @NotNull
        BodyType bodyType,
        int numberOfSeats,
        int trunkCapacityInLitres,
        @NotNull
        String averageConsumptionPer100Km,
        @NotNull
        String bodySerialNumber,
        long pricePerDayInPolishGrosz,
        boolean available,
        int rangeInKilometers,
        @NotNull
        PicturesDto pictures
) {
}
