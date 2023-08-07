package pl.sda.carconnect.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    String street;
    String zipCode;
    String city;
    String houseNumber;
    String country;
    String voivodeship;
}
