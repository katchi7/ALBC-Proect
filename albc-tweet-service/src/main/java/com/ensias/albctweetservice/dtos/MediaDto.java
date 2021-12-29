package com.ensias.albctweetservice.dtos;

import com.ensias.albctweetservice.model.Media;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDto {
    public MediaDto(Media media){
        this(media.getMediaId(),media.getMediaUrl(),media.getMedialName(),media.getMediaType());
    }
    private Long mediaId;
    @NotNull
    private String mediaUrl;
    @NotNull
    private String medialName;
    private String mediaType;
    public Media asMedia(){
        return new Media(mediaId,mediaUrl,medialName,mediaType);
    }
}
