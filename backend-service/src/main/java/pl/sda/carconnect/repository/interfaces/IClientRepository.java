package pl.sda.carconnect.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carconnect.domain.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
