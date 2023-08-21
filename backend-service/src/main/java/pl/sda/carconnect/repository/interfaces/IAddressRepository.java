package pl.sda.carconnect.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carconnect.domain.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
