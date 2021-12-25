package com.ensias.albcusertimelineservice.dtos;


import com.ensias.albcusertimelineservice.model.Likes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetLikeDto {
    public TweetLikeDto(Likes likes){
        this(likes.getLikeId(), likes.getUserId());
    }

    private Long likeId;
    @NotNull
    private Long userId;
    public Likes asLike(){
        return new Likes(likeId,userId);
    }

}
