package pl.sda.carconnect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.carconnect.domain.Client;
import pl.sda.carconnect.dto.CarDto;
import pl.sda.carconnect.dto.ClientDto;
import pl.sda.carconnect.mapper.ClientMapper;
import pl.sda.carconnect.service.ClientService;

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
}
