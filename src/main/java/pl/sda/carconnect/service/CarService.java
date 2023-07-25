package pl.sda.carconnect.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.repository.CarRepository;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public void addCar(Car car) {
        carRepository.addCar(car);
    }
}
