package pl.sda.carconnect.dto;

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
