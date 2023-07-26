package pl.sda.carconnect.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.exception.WrongCarIdException;
import pl.sda.carconnect.repository.interfaces.ICarRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CarRepository {
    private final ICarRepository iCarRepository;

    public void addCar(Car car) {
        iCarRepository.save(car);
    }

    public List<Car> getAllCars() {
        return iCarRepository.findAll();
    }

    public Car findCarById(Long id) {
        return iCarRepository.findById(id)
                .orElseThrow(() -> new WrongCarIdException("Car with id: [" + id +"] not found."));
    }
}
