package pl.sda.carconnect.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.carconnect.domain.Address;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.domain.CarBooking;
import pl.sda.carconnect.domain.Client;
import pl.sda.carconnect.dto.CarBookingRequestDto;
import pl.sda.carconnect.exception.WrongDateInputException;
import pl.sda.carconnect.repository.CarBookingRepository;

import java.time.LocalDate;
import java.time.Period;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarBookingService {
    private final CarBookingRepository carBookingRepository;
    private final CarService carService;
    private final ClientService clientService;
    private final AddressService addressService;

    @Transactional
    public CarBooking bookCar(CarBookingRequestDto bookingDto) {
        log.info("Car booking service: [{}]", bookingDto);
        Car car = carService.findCarById(bookingDto.bookedCarId());
        Client client = clientService.findClientById(bookingDto.clientId());
        Address startLocation = addressService.findAddressById(bookingDto.startLocationId());
        Address finalLocation = addressService.findAddressById(bookingDto.finalLocationId());
        long finalPrice = calculateFinalBookingPrice(
                bookingDto.startDate(),
                bookingDto.returnDate(),
                car.getPricePerDayInPolishGrosz()
        );

        CarBooking bookingRecord = CarBooking.builder()
                .bookedCar(car)
                .client(client)
                .startLocation(startLocation)
                .finalLocation(finalLocation)
                .startDate(bookingDto.startDate())
                .returnDate(bookingDto.returnDate())
                .totalPriceInPolishGrosz(finalPrice)
                .build();
        return carBookingRepository.bookCar(bookingRecord);
    }

    public long calculateFinalBookingPrice(
            final LocalDate startDate,
            final LocalDate finalDate,
            final long pricePerDay) {
        if(startDate.isAfter(finalDate) || startDate.isEqual(finalDate)) {
            throw new WrongDateInputException("Wrong dates provided, start date = [%s], final date = [%s]".formatted(startDate, finalDate));
        }
        int days = Period.between(startDate, finalDate).getDays();
        long finalPrice = days * pricePerDay;
        log.info("Price for booking car starting on [{}] ending on [{}] is [{}]", startDate, finalDate, finalPrice);
        return finalPrice;
    }
}
