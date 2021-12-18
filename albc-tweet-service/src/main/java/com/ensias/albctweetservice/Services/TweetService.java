package com.ensias.albctweetservice.Services;

import com.ensias.albctweetservice.Exceptions.TweetServiceException;
import com.ensias.albctweetservice.Repositories.*;
import com.ensias.albctweetservice.api.UserServiceApi;
import com.ensias.albctweetservice.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class TweetService  {
    private final TweetRepo tweetRepo;
    private final UserServiceApi userServiceApi;
    private final CommentRepo commentRepo;
    private final MediaRepo mediaRepo;
    private final RetweetRepo retweetRepo;
    private final LikesRepo likesRepo;

    public TweetService(TweetRepo repo, UserServiceApi userServiceApi, CommentRepo commentRepo, MediaRepo mediaRepo, RetweetRepo retweetRepo, LikesRepo likesRepo) {
        this.tweetRepo = repo;
        this.userServiceApi = userServiceApi;
        this.commentRepo = commentRepo;
        this.mediaRepo = mediaRepo;
        this.retweetRepo = retweetRepo;
        this.likesRepo = likesRepo;
    }

    public Tweet createTweet(Tweet tweet){
        if(tweet.getMedia()!=null) mediaRepo.saveAll(tweet.getMedia());
        return tweetRepo.save(tweet);
    }
    public Tweet findTweetById(Long id){
        Tweet tweet = tweetRepo.findById(id).orElse(null);
        if(tweet == null ){
            throw new TweetServiceException(HttpStatus.NOT_FOUND,"Cannot find tweet");
        }
        User user = userServiceApi.getUser(tweet.getUserId());
        tweet.setUser(user);
        return tweet;
    }
    public Tweet likeTweet(Long id, Likes likes){
        User user = userServiceApi.getUser(likes.getUserId());
        Tweet tweet = tweetRepo.findById(id).orElse(null);
        if(tweet == null ){
            throw new TweetServiceException(HttpStatus.NOT_FOUND,"Cannot find tweet");
        }
        if(tweet.getLikes()==null) tweet.setLikes(List.of(likes));
        else if(tweet.getLikes().stream().map(Likes::getUserId).noneMatch(Predicate.isEqual(likes.getUserId()))) tweet.getLikes().add(likes);
        likesRepo.save(likes);
        return tweetRepo.save(tweet);

    }
    public Tweet commentOnTweet(Long id, Comment comment){
        User user = userServiceApi.getUser(comment.getUserId());
        Tweet tweet = tweetRepo.findById(id).orElse(null);
        if(tweet == null ){
            throw new TweetServiceException(HttpStatus.NOT_FOUND,"Cannot find tweet");
        }
        if(tweet.getComments()==null) tweet.setComments(List.of(comment));
        else tweet.getComments().add(comment);
        commentRepo.save(comment);
        return tweetRepo.save(tweet);
    }
    public Tweet retweet(Long id, Retweet retweet){
        User user = userServiceApi.getUser(retweet.getUserId());
        Tweet tweet = tweetRepo.findById(id).orElse(null);
        if(tweet == null ){
            throw new TweetServiceException(HttpStatus.NOT_FOUND,"Cannot find tweet");
        }
        if(tweet.getRetweets()==null) tweet.setRetweets(List.of(retweet));
        else tweet.getRetweets().add(retweet);
        retweetRepo.save(retweet);
        return tweetRepo.save(tweet);
    }
    public void deleteTweet(Long userId,Long tweetId){
        Tweet tweet = tweetRepo.findById(tweetId).orElse(null);
        if(tweet == null ){
            throw new TweetServiceException(HttpStatus.NOT_FOUND,"Cannot find tweet");
        }
        if(tweet.getUserId()==null||!tweet.getUserId().equals(userId)) throw new TweetServiceException(HttpStatus.UNAUTHORIZED,"Operation unauthorized");

        tweetRepo.delete(tweet);
    }
}
