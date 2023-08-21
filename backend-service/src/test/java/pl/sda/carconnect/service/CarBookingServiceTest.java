package pl.sda.carconnect.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.carconnect.exception.WrongDateInputException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarBookingServiceTest {

    @Autowired
    CarBookingService carBookingService;

    @Test
    void checkInjectionBean() {
        Assertions.assertNotNull(carBookingService, "Should not be null");
    }

    @Test
    void calculateFinalBookingPricePositiveCase() {
        LocalDate startDate = LocalDate.now();
        LocalDate finalDate = startDate.plusDays(3);
        long pricePerDayInPolishGrosz = 10_000L;
        long actualPrice = carBookingService.calculateFinalBookingPrice(startDate, finalDate, pricePerDayInPolishGrosz);
        Assertions.assertEquals(30_000, actualPrice);
    }

    @Test
    void calculateFinalBookingPriceWrongDateRange() {
        LocalDate startDate = LocalDate.now();
        LocalDate finalDate = startDate.minusDays(3);
        long pricePerDayInPolishGrosz = 10_000L;
        Assertions.assertThrows(
                WrongDateInputException.class,
                () ->
                    carBookingService.calculateFinalBookingPrice(startDate, finalDate, pricePerDayInPolishGrosz),
                "Should throw WrongDateInputException");
    }

    @Test
    void calculateFinalBookingPriceWrongDateRange_endDateEqualsStartDate() {
        LocalDate startDate = LocalDate.now();
        LocalDate finalDate = startDate.plusDays(0);
        long pricePerDayInPolishGrosz = 10_000L;
        Assertions.assertThrows(
                WrongDateInputException.class,
                () ->
                        carBookingService.calculateFinalBookingPrice(startDate, finalDate, pricePerDayInPolishGrosz),
                "Should throw WrongDateInputException");
    }
}