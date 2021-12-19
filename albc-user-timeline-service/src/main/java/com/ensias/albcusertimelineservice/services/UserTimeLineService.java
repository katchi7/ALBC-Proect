package com.ensias.albcusertimelineservice.services;

import com.ensias.albcusertimelineservice.api.UserServiceApi;
import com.ensias.albcusertimelineservice.dtos.MediaDto;
import com.ensias.albcusertimelineservice.dtos.TweetDto;
import com.ensias.albcusertimelineservice.dtos.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTimeLineService {
    private final UserServiceApi userServiceApi;

    public UserTimeLineService(UserServiceApi userServiceApi) {
        this.userServiceApi = userServiceApi;
    }

    public List<TweetDto> findTweetsByUser(Long userId){
        User user = userServiceApi.getUser(userId);
        //get DATA
        return List.of(new TweetDto());

    }
    public List<TweetDto> findTweetsAndResponsesByUser(Long userId){
        User user = userServiceApi.getUser(userId);
        //Get Data
        return List.of(new TweetDto());
    }
    public List<MediaDto> findUserMedia(Long userId){
        User user = userServiceApi.getUser(userId);
        //Get Data
        return List.of(new MediaDto());
    }
    public List<TweetDto> findUserLikedTweets(Long userId){
        User user = userServiceApi.getUser(userId);
        //Get Data
        return List.of(new TweetDto());
    }
}
