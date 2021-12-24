package com.ensias.albchometimelineservice.dtos;


import com.ensias.albchometimelineservice.model.Media;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDto {
    public MediaDto(Media media){
        this(media.getMediaId(),media.getMediaUrl(),media.getMedialName(),media.getMediaType());
    }
    private Long mediaId;

    private String mediaUrl;

    private String medialName;
    private String mediaType;
    public Media asMedia(){
        return new Media(mediaId,mediaUrl,medialName,mediaType);
    }
}
