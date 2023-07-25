package pl.sda.carconnect.mapper;

import org.springframework.stereotype.Component;
import pl.sda.carconnect.domain.Car;
import pl.sda.carconnect.dto.CarDto;

@Component
public class CarMapper implements IMapper<Car, CarDto> {
    @Override
    public CarDto fromEntityToDto(Car entity) {
        return null;
    }

    @Override
    public Car fromDtoToEntity(CarDto dto) {
        return null;
    }
}
