package com.ensias.albcusertimelineservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetDto {

    private Long id;
    @NotNull
    @Size(min = 5,max = 500000000)
    private String text;
    @Valid
    private List<MediaDto> media;
    @NotNull
    private Long userId;
    @NotNull
    private Long operatorId;
    private User user;
    private List<TweetLikeDto> likes;

    private List<CommentDto> comments;

    private List<RetweetDto> retweets;

    public boolean validate(){
        return operatorId==userId;
    }
}
