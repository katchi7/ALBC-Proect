package com.ensias.albchometimelineservice.services;

import com.ensias.albchometimelineservice.Repositories.TweetRepo;
import com.ensias.albchometimelineservice.Repositories.UserRepo;
import com.ensias.albchometimelineservice.api.UserServiceApi;
import com.ensias.albchometimelineservice.model.Tweet;
import com.ensias.albchometimelineservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class homeTimeLineService {
    @Autowired
    TweetRepo tweetRepo;
    @Autowired
    UserServiceApi api;
    @Autowired
    UserRepo userRepo;
    public List<Tweet> getUserFeed(Long userId){
        List<Tweet> tweets =  tweetRepo.findAll();

        List<Long> usersIds = tweets.stream().map(Tweet::getUserId).collect(Collectors.toList());
        List<User> users = userRepo.findAllById(usersIds);
        for (Tweet tweet : tweets) {
            for (User user : users) {
                if(user.getId().equals(tweet.getUserId())) {
                    tweet.setUser(user);
                    break;
                }
            }
        }
        return tweets;
    }
    public List<User> getOtherUsers(Long userId){
        return api.getOtherUser(userId);
    }
}
