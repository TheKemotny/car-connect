package pl.sda.carconnect.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RENTS")
public class CarBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Car bookedCar;

    @ManyToOne
    Client client;
    LocalDate startDate;
    LocalDate returnDate;
    int totalPriceInPolishGrosz;

    @ManyToOne
    Address startLocation;

    @ManyToOne
    Address finalLocation;
}
