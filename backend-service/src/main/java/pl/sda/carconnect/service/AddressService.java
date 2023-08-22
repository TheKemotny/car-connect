package pl.sda.carconnect.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.carconnect.domain.Address;
import pl.sda.carconnect.dto.AddressDto;
import pl.sda.carconnect.repository.AddressRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address findAddressById(Long aLong) {
        return addressRepository.findAddressById(aLong);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }

    public Address addAddress(Address address) {
        return addressRepository.addAddress(address);
    }
}
