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
    private final AddressMapper addressMapper;

    @Override
    public ClientDto fromEntityToDto(Client entity) {
        return ClientDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .pesel(entity.getPesel())
                .email(entity.getEmail())
                .surname(entity.getSurname())
                .address(addressMapper.fromEntityToDto(entity.getAddress()))
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
                .address(addressMapper.fromDtoToEntity(dto.address()))
                .build();
    }
}
