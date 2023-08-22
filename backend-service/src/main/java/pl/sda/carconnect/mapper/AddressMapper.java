package pl.sda.carconnect.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.carconnect.domain.Address;
import pl.sda.carconnect.dto.AddressDto;

@Component
public class AddressMapper implements IMapper<Address, AddressDto>{
    @Override
    public AddressDto fromEntityToDto(Address entity) {
        return AddressDto.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .zipCode(entity.getZipCode())
                .city(entity.getCity())
                .houseNumber(entity.getHouseNumber())
                .country(entity.getCountry())
                .voivodeship(entity.getVoivodeship())
                .build();
    }

    @Override
    public Address fromDtoToEntity(AddressDto dto) {
        return Address.builder()
                .id(dto.id())
                .street(dto.street())
                .zipCode(dto.zipCode())
                .city(dto.city())
                .houseNumber(dto.houseNumber())
                .country(dto.country())
                .voivodeship(dto.voivodeship())
                .build();
    }
}
