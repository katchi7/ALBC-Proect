package com.ensias.albctweetservice.controllers;

import com.ensias.albctweetservice.Exceptions.TweetServiceException;
import com.ensias.albctweetservice.Services.TweetService;
import com.ensias.albctweetservice.dtos.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/tweet")
public class TweetController {
    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping("")
    public HttpEntity<OperationResponse> createTweet(@RequestBody @Valid TweetDto tweetDto, Errors errors, HttpServletRequest request){
        if(errors.hasErrors()){
            throw new TweetServiceException(HttpStatus.BAD_REQUEST,"Got an invalid request");
        }
        if(!tweetDto.validate()){
            throw new TweetServiceException(HttpStatus.UNAUTHORIZED,"request unauthorized");
        }
        tweetService.createTweet(tweetDto.asTweet());
        return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(), null,"Tweet Created",request.getServletPath()));
    }
    @GetMapping("/{id}")
    public HttpEntity<TweetDto> getTweetById(@PathVariable("id") Long id){
        return ResponseEntity.ok(new TweetDto(tweetService.findTweetById(id)));
    }
    @PutMapping("/like/{id}")
    public HttpEntity<OperationResponse> likeTweet(@PathVariable("id") Long id, @RequestBody @Valid TweetLikeDto dto,Errors errors,HttpServletRequest request){
        tweetService.likeTweet(id,dto.asLike());
        return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(), null,"Like added",request.getServletPath()));
    }
    @PutMapping("/comment/{id}")
    public HttpEntity<OperationResponse> commentOnTweet(@PathVariable("id") Long id, @RequestBody CommentDto dto,HttpServletRequest request){
        tweetService.commentOnTweet(id,dto.asComment());
        return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(), null,"Comment added",request.getServletPath()));
    }
    @PutMapping("/retweet/{id}")
    public HttpEntity<OperationResponse> retweet(@PathVariable("id") Long id, @RequestBody RetweetDto dto,HttpServletRequest request){
        tweetService.retweet(id,dto.asRetweet());
        return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(), null,"retweeted",request.getServletPath()));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<OperationResponse> deleteTweet(@PathVariable("id") Long id,@RequestBody @Valid DeleteTweetDto dto,Errors errors,HttpServletRequest request){
        if(errors.hasErrors()) throw new TweetServiceException(HttpStatus.BAD_REQUEST,"Bad request params");
        if(!dto.validate()) throw new TweetServiceException(HttpStatus.UNAUTHORIZED,"Operation unauthorized");
        tweetService.deleteTweet(dto.getUserId(), id);
        return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(),null,"Operation done",request.getServletPath()));

    }
}
