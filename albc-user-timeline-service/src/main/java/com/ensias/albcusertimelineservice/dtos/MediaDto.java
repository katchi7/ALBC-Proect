package com.ensias.albcusertimelineservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDto {

    private Long mediaId;
    @NotNull
    private String mediaUrl;
    @NotNull
    private String medialName;
    private String mediaType;

}
