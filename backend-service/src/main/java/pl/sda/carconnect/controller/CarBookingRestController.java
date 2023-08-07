package pl.sda.carconnect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.carconnect.dto.CarBookingDto;
import pl.sda.carconnect.service.CarBookingService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/car-booking")
public class CarBookingRestController {
    private final CarBookingService carBookingService;

    @PostMapping("/car-bookings")
    public CarBookingDto bookCar(@RequestBody CarBookingDto bookingDto) {
        return null;
    }
}
