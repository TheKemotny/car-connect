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
        Car opel = Car.builder()
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
        Car mustang = Car.builder()
                .brand("Ford")
                .model("Mustang")
                .available(true)
                .bodySerialNumber("XYZ")
                .bodyType(BodyType.MUSCLE)
                .engineType(EngineType.V6)
                .fuelType(FuelType.GASOLINE)
                .averageConsumptionPer100Km("17")
                .numberOfSeats(5)
                .pricePerDayInPolishGrosz(30000)
                .rangeInKilometers(400)
                .trunkCapacityInLitres(10)
                .pictures(Pictures.builder()
                        .mainPictureUrl("https://www.autocentrum.pl/Zy12aS5qdRhQUBdgGgp4DBMIQ3xUEncfWF4EfFYQKFRHVxMgXB40VgRTVjAFEz5BBAVUYwcQOxgJClMwUBNpGx5UDiFRXDcMQkYAPVJcLBAfWBE0Fww")
                        .otherPicturesUrls(List.of("https://www.ford.pl/content/dam/guxeu/rhd/central/cars/2020-mustang-mach-1/future-vehicle/features/ford-mustang_mach1-eu-CCL_MustangS550_3_MUS_M_L_51215_CC_N_D-16x9-2160x1215_FEATURES_en_EU-.jpg.renditions.original.png"))
                        .build())
                .build();
        carService.addCar(opel);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("run is running");
        initCars();
    }
}
