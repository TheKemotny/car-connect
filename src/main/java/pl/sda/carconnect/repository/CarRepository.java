package pl.sda.carconnect.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.repository.interfaces.ICarRepository;

@Repository
@RequiredArgsConstructor
public class CarRepository {
    private final ICarRepository iCarRepository;

    public void addCar(Car car) {
        iCarRepository.save(car);
    }
}
