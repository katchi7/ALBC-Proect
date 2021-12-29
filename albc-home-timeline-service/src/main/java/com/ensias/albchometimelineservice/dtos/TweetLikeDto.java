package com.ensias.albchometimelineservice.dtos;


import com.ensias.albchometimelineservice.model.Likes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetLikeDto {
    public TweetLikeDto(Likes likes){
        this(likes.getLikeId(), likes.getUserId());
    }
    private Long likeId;

    private Long userId;
    public Likes asLike(){
        return new Likes(likeId,userId);
    }
}
