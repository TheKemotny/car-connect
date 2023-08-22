package pl.sda.carconnect.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.sda.carconnect.dto.CarDto;
import pl.sda.carconnect.dto.ClientDto;
import pl.sda.carconnect.mapper.ClientMapper;
import pl.sda.carconnect.service.ClientService;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/clients")
@CrossOrigin("*")
public class ClientRestController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping
    public List<ClientDto> getAllClients() {
        log.info("All Clients Request Get");
        return clientService.findAllClients().stream()
                .map(clientMapper::fromEntityToDto)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public ClientDto getClientById(@PathVariable("id") Long id) {
        log.info("Trying to get client with id: [{}]", id);
        return clientMapper.fromEntityToDto(clientService.findClientById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addClient(@RequestBody @Valid ClientDto clientDto, UriComponentsBuilder uriComponentsBuilder) {
        log.info("Trying to add client: [{}]", clientDto);
        ClientDto resultDtoClient = clientMapper.fromEntityToDto(clientService.addClient(clientMapper.fromDtoToEntity(clientDto)));
        URI uri = uriComponentsBuilder.path("/api/client/{id}").buildAndExpand(resultDtoClient.id()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
