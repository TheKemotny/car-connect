package pl.sda.carconnect.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.dto.CarDto;
import pl.sda.carconnect.mapper.CarMapper;
import pl.sda.carconnect.service.CarService;

import java.net.URI;
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
        log.info("Trying to get car with id: [{}]", id);
        return carMapper.fromEntityToDto(carService.findCarById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addCar(@RequestBody @Valid CarDto carDto, UriComponentsBuilder uriComponentsBuilder) {
        log.info("Trying to add car: [{}]", carDto);
        CarDto resultDtoCar = carMapper.fromEntityToDto(carService.addCar(carMapper.fromDtoToEntity(carDto)));
        URI uri = uriComponentsBuilder.path("/api/cars/{id}").buildAndExpand(resultDtoCar.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long id) {
        log.info("Trying to delete car with id: [{}]", id);
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public CarDto replaceCar(@PathVariable("id") Long id, @RequestBody @Valid CarDto toReplace) {
        log.info("Trying to update car with id: [{}] with put method content: [{}]", id, toReplace);
        carService.replaceCar(id, carMapper.fromDtoToEntity(toReplace));
        return null;
    }
}
