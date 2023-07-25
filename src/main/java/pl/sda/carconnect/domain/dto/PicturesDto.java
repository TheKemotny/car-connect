package pl.sda.carconnect.domain.dto;

import java.util.List;

public record PicturesDto(
        String mainPictureUrl,
        List<String> otherPicturesUrls
) {
}
