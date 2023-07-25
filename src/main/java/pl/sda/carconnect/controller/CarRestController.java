package pl.sda.carconnect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.carconnect.dto.CarDto;
import pl.sda.carconnect.mapper.CarMapper;
import pl.sda.carconnect.service.CarService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/cars")
public class CarRestController {
    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping
    public List<CarDto> getAllCars() {
        log.info("All Cars Request Get");
        return carService.getAllCars().stream()
                .map(carMapper::fromEntityToDto)
                .toList();
    }
}
