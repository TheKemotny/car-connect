package pl.sda.carconnect.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    LocalDateTime timestampOfCreation;

    LocalDateTime timestampOfLastUpdate;

    @PrePersist
    void writeTimestampOfCreation() {
        this.timestampOfCreation = LocalDateTime.now();
        this.timestampOfLastUpdate = this.timestampOfCreation;
    }

    @PreUpdate
    void writeTimestampOfLastUpdate() {
        this.timestampOfLastUpdate = LocalDateTime.now();
    }
}
