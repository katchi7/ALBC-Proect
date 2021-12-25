package com.ensias.albcusertimelineservice.services;

import com.ensias.albcusertimelineservice.Repositories.TweetRepo;
import com.ensias.albcusertimelineservice.api.UserServiceApi;
import com.ensias.albcusertimelineservice.dtos.MediaDto;
import com.ensias.albcusertimelineservice.dtos.TweetDto;
import com.ensias.albcusertimelineservice.model.Tweet;
import com.ensias.albcusertimelineservice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTimeLineService {
    private final UserServiceApi userServiceApi;
    private final TweetRepo tweetRepo;

    public UserTimeLineService(UserServiceApi userServiceApi, TweetRepo tweetRepo) {
        this.userServiceApi = userServiceApi;
        this.tweetRepo = tweetRepo;
    }

    public List<Tweet> findTweetsByUser(Long userId){
        User user = userServiceApi.getUser(userId);
        List<Tweet> tweets = tweetRepo.findTweetByUserId(userId);
        tweets.forEach(p->p.setUser(user));
        return tweets;

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
