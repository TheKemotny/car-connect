package pl.sda.carconnect.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.sda.carconnect.domain.Client;
import pl.sda.carconnect.exception.WrongCarIdException;
import pl.sda.carconnect.exception.WrongClientIdException;
import pl.sda.carconnect.repository.interfaces.IClientRepository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClientRepository {
    private final IClientRepository iClientRepository;

    public Client findClientById(Long aLong) {
        return iClientRepository.findById(aLong)
                .map(client -> {
                    log.info("Found client: [{}]", client);
                    return client;
                })
                .orElseThrow(() -> new WrongClientIdException("Client with id: [" + aLong +"] not found."));
    }
}
