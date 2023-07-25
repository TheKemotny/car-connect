package pl.sda.carconnect.dto;

import pl.sda.carconnect.domain.enumeration.BodyType;
import pl.sda.carconnect.domain.enumeration.EngineType;
import pl.sda.carconnect.domain.enumeration.FuelType;

public record CarDto(
        Long id,
        String model,
        String brand,
        FuelType fuelType,
        EngineType engineType,
        BodyType bodyType,
        int numberOfSeats,
        int trunkCapacityInLitres,
        String averageConsumptionPer100Km,
        String bodySerialNumber,
        long pricePerDayInPolishGrosz,
        boolean available,
        int rangeInKilometers,
        PicturesDto pictures
) {
}
