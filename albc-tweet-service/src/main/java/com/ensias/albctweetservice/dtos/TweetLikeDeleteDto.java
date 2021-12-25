package com.ensias.albctweetservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetLikeDeleteDto {
    @NotNull
    public Long userId;
    @NotNull
    public Long tweetId;
    @NotNull
    public Long operatorId;
}
