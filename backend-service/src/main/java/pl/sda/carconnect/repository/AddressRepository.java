package pl.sda.carconnect.repository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.sda.carconnect.domain.Address;
import pl.sda.carconnect.exception.WrongAddressIdException;
import pl.sda.carconnect.repository.interfaces.IAddressRepository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class AddressRepository {
    private final IAddressRepository iAddressRepository;

    public Address findAddressById(Long aLong) {
        return iAddressRepository.findById(aLong)
                .map(address -> {
                    log.info("Found car: [{}]", address);
                    return address;
                })
                .orElseThrow(() -> new WrongAddressIdException("Car with id: [" + aLong +"] not found."));
    }

    public Address addAddress(Address address) {
        log.info("Saving address: [{}]", address);
        iAddressRepository.save(address);
        return address;
    }

    public List<Address> getAllAddresses() {
        log.info("Getting all address");
        return iAddressRepository.findAll();
    }
}
