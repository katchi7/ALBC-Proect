package com.ensias.albcusertimelineservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetLikeDto {
    private Long likeId;
    @NotNull
    private Long userId;

}
