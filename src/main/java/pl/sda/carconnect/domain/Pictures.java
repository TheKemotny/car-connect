package pl.sda.carconnect.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pictures {
    String mainPictureUrl;
    @ElementCollection
    List<String> otherPicturesUrls;
}