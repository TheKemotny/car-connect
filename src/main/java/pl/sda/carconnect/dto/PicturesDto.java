package pl.sda.carconnect.dto;

import java.util.List;

public record PicturesDto(
        String mainPictureUrl,
        List<String> otherPicturesUrls
) {
}
