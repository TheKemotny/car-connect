package pl.sda.carconnect.dto;

import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClientDto(
        Long id,
        String name,
        String surname,
        String pesel,
        String email,
        LocalDate dateOfBirth,
        LocalDateTime dateOfAccountCreated,
        String phoneNumber,
        AddressDto address
) {
}
