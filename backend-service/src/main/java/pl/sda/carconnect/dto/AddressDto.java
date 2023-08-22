package pl.sda.carconnect.dto;

import lombok.Builder;

@Builder
public record AddressDto(
        Long id,

        String street,
        String zipCode,
        String city,
        String houseNumber,
        String country,
        String voivodeship
) {
}
