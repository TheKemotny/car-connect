package pl.sda.carconnect.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carconnect.domain.Car;

public interface ICarRepository extends JpaRepository<Car, Long> {
}
