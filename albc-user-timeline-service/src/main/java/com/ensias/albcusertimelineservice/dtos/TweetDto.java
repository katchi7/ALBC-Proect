package com.ensias.albcusertimelineservice.dtos;


import com.ensias.albcusertimelineservice.model.Tweet;
import com.ensias.albcusertimelineservice.model.User;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetDto {
    public TweetDto(Tweet tweet){
        this(
                tweet.getId(),tweet.getText(),
                tweet.getMedia()==null?null:tweet.getMedia().stream().map(MediaDto::new).collect(Collectors.toList()),
                tweet.getUserId(),
                tweet.getCreatedAt(),
                null,
                tweet.getUser(),
                tweet.getLikes()==null?null:tweet.getLikes().stream().map(TweetLikeDto::new).collect(Collectors.toList()),
                tweet.getComments()==null?null:tweet.getComments().stream().map(CommentDto::new).collect(Collectors.toList()),
                tweet.getRetweets()==null?null:tweet.getRetweets().stream().map(RetweetDto::new).collect(Collectors.toList())

        );

    }
    private Long id;
    @NotNull
    @Size(min = 5,max = 500000000)
    private String text;
    @Valid
    private List<MediaDto> media;
    @NotNull
    private Long userId;
    private Date createdAt;
    @NotNull
    private Long operatorId;
    private User user;
    private List<TweetLikeDto> likes;

    private List<CommentDto> comments;

    private List<RetweetDto> retweets;
    public Tweet asTweet(){
        return new Tweet(
                id,text,media==null?null:media.stream().map(MediaDto::asMedia).collect(Collectors.toList()),
                userId,createdAt,user,
                likes==null?null:likes.stream().map(TweetLikeDto::asLike).collect(Collectors.toList()),
                comments==null?null:comments.stream().map(CommentDto::asComment).collect(Collectors.toList()),
                retweets==null?null:retweets.stream().map(RetweetDto::asRetweet).collect(Collectors.toList())
        );
    }
    @JsonSetter("createdAt")
    public void createdAtSetter(String in){
        createdAt = new Date();
    }
    public boolean validate(){
        return operatorId==userId;
    }
}
