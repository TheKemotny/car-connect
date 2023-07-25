package pl.sda.carconnect.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.domain.Pictures;
import pl.sda.carconnect.domain.enumeration.BodyType;
import pl.sda.carconnect.domain.enumeration.EngineType;
import pl.sda.carconnect.domain.enumeration.FuelType;
import pl.sda.carconnect.service.CarService;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("dev")
public class DataInitializer implements CommandLineRunner {
    private final CarService carService;

    public void initCars() {
        Car car = Car.builder()
                .brand("Opel")
                .model("Zafira")
                .available(true)
                .bodySerialNumber("ABC")
                .bodyType(BodyType.SUV)
                .engineType(EngineType.V6)
                .fuelType(FuelType.LPG)
                .averageConsumptionPer100Km("10")
                .numberOfSeats(7)
                .pricePerDayInPolishGrosz(10000)
                .rangeInKilometers(400)
                .trunkCapacityInLitres(10)
                .pictures(Pictures.builder()
                        .mainPictureUrl("https://i.wpimg.pl/616x462/m.autokult.pl/opel-zafira-616x462-8ac2a44bcd1e.jpg")
                        .otherPicturesUrls(List.of("https://upload.wikimedia.org/wikipedia/commons/a/ac/Opel_Zafira_inside_20080906.jpg"))
                        .build())
                .build();
        carService.addCar(car);
        log.info("Car: {} added to database", car);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("run is running");
        initCars();
    }
}
