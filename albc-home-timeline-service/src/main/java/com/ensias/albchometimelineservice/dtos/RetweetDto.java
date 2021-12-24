package com.ensias.albchometimelineservice.dtos;


import com.ensias.albchometimelineservice.model.Retweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetweetDto {
    public RetweetDto(Retweet retweet){
        this(retweet.getRetweetId(), retweet.getUserId());
    }
    private Long retweetId;

    private Long userId;
    public Retweet asRetweet(){
        return new Retweet(retweetId,userId);
    }
}
