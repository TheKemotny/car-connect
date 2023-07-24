package pl.sda.carconnect.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.carconnect.domain.enumeration.BodyType;
import pl.sda.carconnect.domain.enumeration.EngineType;
import pl.sda.carconnect.domain.enumeration.FuelType;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
@Table(name = "CARS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String model;

    String brand;

    @Enumerated(EnumType.STRING)
    FuelType fuelType;

    @Enumerated(EnumType.STRING)
    EngineType engineType;

    @Enumerated(EnumType.STRING)
    BodyType bodyType;

    int numberOfSeats;

    int trunkCapacityInLitres;

    String averageConsumptionPer100Km;

    String bodySerialNumber;

    long pricePerDayInPolishGrosz;

    boolean available;

    int rangeInKilometers;

    Pictures pictures;
}
