package pl.sda.carconnect.mapper;

import org.springframework.stereotype.Component;
import pl.sda.carconnect.domain.Pictures;
import pl.sda.carconnect.dto.PicturesDto;

@Component
public class PicturesMapper implements IMapper<Pictures, PicturesDto> {
    @Override
    public PicturesDto fromEntityToDto(Pictures entity) {
        return PicturesDto.builder()
                .mainPictureUrl(entity.getMainPictureUrl())
                .otherPicturesUrls(entity.getOtherPicturesUrls())
                .build();
    }

    @Override
    public Pictures fromDtoToEntity(PicturesDto dto) {
        return Pictures.builder()
                .mainPictureUrl(dto.mainPictureUrl())
                .otherPicturesUrls(dto.otherPicturesUrls())
                .build();
    }
}
