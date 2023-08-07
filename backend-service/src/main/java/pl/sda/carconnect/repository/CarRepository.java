package pl.sda.carconnect.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.exception.WrongCarIdException;
import pl.sda.carconnect.repository.interfaces.ICarRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CarRepository {
    private final ICarRepository iCarRepository;

    public Car addCar(Car car) {
        Car carWithId = iCarRepository.save(car);
        log.info("Saving car: [{}]", carWithId);
        return carWithId;
    }

    public List<Car> getAllCars() {
        log.info("Getting all cars");
        return iCarRepository.findAll();
    }

    public Car findCarById(Long id) {
        return iCarRepository.findById(id)
                .map(car -> {
                    log.info("Found car: [{}]", car);
                    return car;
                })
                .orElseThrow(() -> new WrongCarIdException("Car with id: [" + id +"] not found."));
    }

    public void deleteCarById(Long id) {
        if(!iCarRepository.existsById(id)) {
            throw new WrongCarIdException("Car with id: [" + id + "] not found.");
        }
        iCarRepository.deleteById(id);
        log.info("Deleted car with id: [{}]", id);
    }

    public Car replaceCar(Long id, Car car) {
        if(!iCarRepository.existsById(id)) {
            throw new WrongCarIdException("Car with id: [" + id + "] not found.");
        }
        if(!id.equals(car.getId())) {
            throw new WrongCarIdException("Car id mismatch, path id: [%d], body id: [%d].".formatted(id, car.getId()));
        }
        log.info("Replacing car with id: [{}] with new car: [{}]", id, car);

        return iCarRepository.save(car);
    }
}
