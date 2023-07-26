package pl.sda.carconnect.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "/{id}")
    public CarDto getCarById(@PathVariable("id") Long id) {
        log.info("Trying to get car with id: []{}", id);
        return carMapper.fromEntityToDto(carService.findCarById(id));
    }

}
