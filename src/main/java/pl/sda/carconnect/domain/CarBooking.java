package pl.sda.carconnect.domain;

import java.time.LocalDate;

public class CarBooking {
    Car bookedCar;
    Client client;
    LocalDate startDate;
    LocalDate returnDate;
    int totalPriceInPolishGrosz;
    Address startLocation;
    Address finalLocation;
}
