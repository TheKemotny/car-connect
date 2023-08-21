package pl.sda.carconnect.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.sda.carconnect.domain.CarBooking;
import pl.sda.carconnect.dto.CarBookingRequestDto;
import pl.sda.carconnect.repository.interfaces.ICarBookingRepository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CarBookingRepository {
    private final ICarBookingRepository iCarBookingRepository;

    public CarBooking bookCar(CarBookingRequestDto bookingDto) {
        return null;
    }
}
