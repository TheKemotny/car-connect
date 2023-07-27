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

    public Car addCar(Car car) {
        return carRepository.addCar(car);
    }

    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    public Car findCarById(Long id) {
        return carRepository.findCarById(id);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteCarById(id);
    }
}
