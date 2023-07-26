package pl.sda.carconnect.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2)
    String model;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2)
    String brand;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    FuelType fuelType;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    EngineType engineType;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    BodyType bodyType;

    int numberOfSeats;

    int trunkCapacityInLitres;

    @Column(nullable = false)
    String averageConsumptionPer100Km;

    @Column(unique = true, nullable = false)
    @NotNull
    String bodySerialNumber;

    long pricePerDayInPolishGrosz;

    boolean available;

    int rangeInKilometers;

    @Column(nullable = false)
    @NotNull
    Pictures pictures;
}
