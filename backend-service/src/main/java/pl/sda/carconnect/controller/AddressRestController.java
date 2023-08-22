package pl.sda.carconnect.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.sda.carconnect.dto.AddressDto;
import pl.sda.carconnect.mapper.AddressMapper;
import pl.sda.carconnect.service.AddressService;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/addresses")
@CrossOrigin("*")
public class AddressRestController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @GetMapping
    public List<AddressDto> getAllAddresses() {
        return addressService.getAllAddresses().stream()
                .map(addressMapper::fromEntityToDto)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public AddressDto getAddressById(@PathVariable("id") Long id) {
        log.info("Trying to get address with id: [{}]", id);
        return addressMapper.fromEntityToDto(addressService.findAddressById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addAddress(@RequestBody @Valid AddressDto addressDto, UriComponentsBuilder uriComponentsBuilder) {
        log.info("Trying to add address: [{}]", addressDto);
        AddressDto resultAddressDto = addressMapper.fromEntityToDto(addressService.addAddress(addressMapper.fromDtoToEntity(addressDto)));
        URI uri = uriComponentsBuilder.path("/api/addresses/{id}").buildAndExpand(resultAddressDto.id()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
