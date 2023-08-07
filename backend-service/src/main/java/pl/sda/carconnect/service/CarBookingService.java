package pl.sda.carconnect.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.carconnect.repository.CarBookingRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarBookingService {
    private final CarBookingRepository carBookingRepository;
}
