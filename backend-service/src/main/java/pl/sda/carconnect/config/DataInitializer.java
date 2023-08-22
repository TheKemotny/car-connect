package pl.sda.carconnect.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.carconnect.domain.Address;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.domain.Client;
import pl.sda.carconnect.domain.Pictures;
import pl.sda.carconnect.domain.enumeration.BodyType;
import pl.sda.carconnect.domain.enumeration.EngineType;
import pl.sda.carconnect.domain.enumeration.FuelType;
import pl.sda.carconnect.repository.AddressRepository;
import pl.sda.carconnect.repository.CarRepository;
import pl.sda.carconnect.repository.ClientRepository;
import pl.sda.carconnect.service.AddressService;
import pl.sda.carconnect.service.CarService;
import pl.sda.carconnect.service.ClientService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("dev")
public class DataInitializer implements CommandLineRunner {
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

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
        carRepository.addCar(opel);
        carRepository.addCar(mustang);
    }

    public void initClientsWithAddresses() {
        Address address = Address.builder()
                .street("Wladyslawa Orkana")
                .zipCode("15-693")
                .city("Bialystok")
                .houseNumber("26")
                .country("PL")
                .voivodeship("podlaskie")
                .build();
        addressRepository.addAddress(address);
        Address secondAddress = Address.builder()
                .street("Zotki-Kolonia")
                .zipCode("15-300")
                .city("Zoltki-Kolonia")
                .houseNumber("53A")
                .country("PL")
                .voivodeship("podlaskie")
                .build();
        addressRepository.addAddress(secondAddress);
        Client client = Client.builder()
                .name("Tomasz")
                .surname("Sz.")
                .pesel("93062206570")
                .email("tomek.szyperek@gmail.com")
                .dateOfBirth(LocalDate.of(1993,6,22))
                .phoneNumber("692460987")
                .address(address)
                .build();
        clientRepository.addClient(client);
        Client secondClient = Client.builder()
                .name("zoo24")
                .surname("zoo24")
                .pesel("12345678901")
                .email("zoo24@zoo24.pl")
                .dateOfBirth(LocalDate.of(2020, 2, 1))
                .phoneNumber("100200300")
                .address(secondAddress)
                .build();
        clientRepository.addClient(secondClient);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("run is running");
        initCars();
        initClientsWithAddresses();
    }
}
