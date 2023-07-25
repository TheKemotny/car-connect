package pl.sda.carconnect.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.repository.CarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {
    private final CarRepository carRepository;

    public void addCar(Car car) {
        carRepository.addCar(car);
        log.info("Adding car: {}", car);
    }

    public List<Car> getAllCars() {
        log.info("Getting all cars");
        return carRepository.getAllCars();
    }
}
