package pl.sda.carconnect.mapper;

import org.springframework.stereotype.Component;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.domain.Pictures;
import pl.sda.carconnect.dto.CarDto;
import pl.sda.carconnect.dto.PicturesDto;

@Component
public class CarMapper implements IMapper<Car, CarDto> {
    @Override
    public CarDto fromEntityToDto(Car entity) {
        return CarDto.builder()
                .id(entity.getId())
                .fuelType(entity.getFuelType())
                .brand(entity.getBrand())
                .engineType(entity.getEngineType())
                .model(entity.getModel())
                .bodyType(entity.getBodyType())
                .numberOfSeats(entity.getNumberOfSeats())
                .trunkCapacityInLitres(entity.getTrunkCapacityInLitres())
                .averageConsumptionPer100Km(entity.getAverageConsumptionPer100Km())
                .bodySerialNumber(entity.getBodySerialNumber())
                .pricePerDayInPolishGrosz(entity.getPricePerDayInPolishGrosz())
                .available(entity.isAvailable())
                .rangeInKilometers(entity.getRangeInKilometers())
                .pictures(PicturesDto.builder()
                        .mainPictureUrl(entity.getPictures().getMainPictureUrl())
                        .otherPicturesUrls(entity.getPictures().getOtherPicturesUrls())
                        .build())
                .build();
    }

    @Override
    public Car fromDtoToEntity(CarDto dto) {
        return Car.builder()
                .id(dto.id())
                .model(dto.model())
                .brand(dto.brand())
                .fuelType(dto.fuelType())
                .engineType(dto.engineType())
                .bodyType(dto.bodyType())
                .numberOfSeats(dto.numberOfSeats())
                .trunkCapacityInLitres(dto.trunkCapacityInLitres())
                .averageConsumptionPer100Km(dto.averageConsumptionPer100Km())
                .bodySerialNumber(dto.bodySerialNumber())
                .pricePerDayInPolishGrosz(dto.pricePerDayInPolishGrosz())
                .available(dto.available())
                .rangeInKilometers(dto.rangeInKilometers())
                .pictures(Pictures.builder()
                        .mainPictureUrl(dto.pictures().mainPictureUrl())
                        .otherPicturesUrls(dto.pictures().otherPicturesUrls())
                        .build())
                .build();
    }
}
