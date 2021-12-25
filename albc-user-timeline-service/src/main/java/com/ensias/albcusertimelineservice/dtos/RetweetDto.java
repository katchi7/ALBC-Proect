package com.ensias.albcusertimelineservice.dtos;


import com.ensias.albcusertimelineservice.model.Retweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetweetDto {
    public RetweetDto(Retweet retweet){
        this(retweet.getRetweetId(), retweet.getUserId());
    }

    private Long retweetId;
    @NotNull
    private Long userId;
    public Retweet asRetweet(){
        return new Retweet(retweetId,userId);
    }
}
