package pl.sda.carconnect.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CLIENTS")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String pesel;
    String email;
    LocalDate dateOfBirth;
    LocalDateTime dateOfAccountCreated;
    String phoneNumber;
    @ManyToOne
    Address address;

    @PrePersist
    void writeDateOfAccountCreated() {
        this.dateOfAccountCreated = LocalDateTime.now();
    }
}
