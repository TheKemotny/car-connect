package pl.sda.carconnect.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CLIENTS")
public class Client {
    @Id
    @Column(nullable = false)
    Long id;
    String name;
    String surname;
    String pesel;
    String email;
    LocalDate dateOfBirth;
    LocalDateTime dateOfAccountCreated;
    String phoneNumber;
    Address address;
}
