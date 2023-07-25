package pl.sda.carconnect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.domain.dto.CarDto;
import pl.sda.carconnect.service.CarService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/cars")
public class CarRestController {
    private final CarService carService;

    @GetMapping
    public List<CarDto> getAllCars() {
        log.info("Request Get");
        return carService.getAllCars();
    }
}
