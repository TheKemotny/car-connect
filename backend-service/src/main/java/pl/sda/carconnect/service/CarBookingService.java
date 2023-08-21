package pl.sda.carconnect.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.domain.CarBooking;
import pl.sda.carconnect.domain.Client;
import pl.sda.carconnect.dto.CarBookingRequestDto;
import pl.sda.carconnect.repository.CarBookingRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarBookingService {
    private final CarBookingRepository carBookingRepository;
    private final CarService carService;
    private final ClientService clientService;

    @Transactional
    public CarBooking bookCar(CarBookingRequestDto bookingDto) {
        log.info("Car booking service: [{}]", bookingDto);
        Car car = carService.findCarById(bookingDto.bookedCarId());
        Client client = clientService.findClientById(bookingDto.clientId());

        return carBookingRepository.bookCar(bookingDto);
    }
}
