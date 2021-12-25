package com.ensias.albcusertimelineservice.Controllers;

import com.ensias.albcusertimelineservice.dtos.MediaDto;
import com.ensias.albcusertimelineservice.dtos.TweetDto;
import com.ensias.albcusertimelineservice.exceptions.UserTimelineException;
import com.ensias.albcusertimelineservice.services.UserTimeLineService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userTimeLine")
public class UserTimeLineController {
    private final UserTimeLineService service;

    public UserTimeLineController(UserTimeLineService service) {
        this.service = service;
    }

    @GetMapping("/tweets")
    public HttpEntity<List<TweetDto>> findTweetsByUser(@RequestParam(name = "userId") Long userId){
        if(userId==null) throw new UserTimelineException(HttpStatus.BAD_REQUEST,"Got an invalid input");
        return ResponseEntity.ok(service.findTweetsByUser(userId).stream().map(TweetDto::new).collect(Collectors.toList()));
    }
    @GetMapping("/tweetsAndResponses")
    public HttpEntity<List<TweetDto>> findTweetsAndResponsesByUser(@RequestParam(name = "userDto") Long userId){
        if(userId==null) throw new UserTimelineException(HttpStatus.BAD_REQUEST,"Got an invalid input");
        return ResponseEntity.ok(service.findTweetsAndResponsesByUser(userId));
    }
    @GetMapping("/userMedia")
    public HttpEntity<List<MediaDto>> findUserMedia(@RequestParam(name = "userDto") Long userId){
        if(userId==null) throw new UserTimelineException(HttpStatus.BAD_REQUEST,"Got an invalid input");
        return ResponseEntity.ok(service.findUserMedia(userId));
    }
    @GetMapping("/userLikedTweets")
    public HttpEntity<List<TweetDto>> findUserLikedTweets(@RequestParam(name = "userDto") Long userId){
        if(userId==null) throw new UserTimelineException(HttpStatus.BAD_REQUEST,"Got an invalid input");
        return ResponseEntity.ok(service.findUserLikedTweets(userId));
    }
}
