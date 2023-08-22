package pl.sda.carconnect.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.carconnect.domain.Address;
import pl.sda.carconnect.domain.Client;
import pl.sda.carconnect.dto.AddressDto;
import pl.sda.carconnect.dto.ClientDto;

@Component
@RequiredArgsConstructor
public class ClientMapper implements IMapper<Client, ClientDto>{
    @Override
    public ClientDto fromEntityToDto(Client entity) {
        return ClientDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .pesel(entity.getPesel())
                .email(entity.getEmail())
                .surname(entity.getSurname())
                .address(AddressDto.builder()
                        .id(entity.getAddress().getId())
                        .street(entity.getAddress().getStreet())
                        .zipCode(entity.getAddress().getZipCode())
                        .city(entity.getAddress().getCity())
                        .houseNumber(entity.getAddress().getHouseNumber())
                        .country(entity.getAddress().getCountry())
                        .voivodeship(entity.getAddress().getVoivodeship())
                        .build())
                .dateOfBirth(entity.getDateOfBirth())
                .dateOfAccountCreated(entity.getDateOfAccountCreated())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

    @Override
    public Client fromDtoToEntity(ClientDto dto) {
        return Client.builder()
                .id(dto.id())
                .name(dto.name())
                .surname(dto.surname())
                .pesel(dto.pesel())
                .email(dto.email())
                .dateOfBirth(dto.dateOfBirth())
                .dateOfAccountCreated(dto.dateOfAccountCreated())
                .phoneNumber(dto.phoneNumber())
                .address(Address.builder()
                        .id(dto.address().id())
                        .street(dto.address().street())
                        .zipCode(dto.address().zipCode())
                        .city(dto.address().city())
                        .houseNumber(dto.address().houseNumber())
                        .country(dto.address().country())
                        .voivodeship(dto.address().voivodeship())
                        .build())
                .build();
    }
}
