package com.ensias.albchometimelineservice.controllers;

import com.ensias.albchometimelineservice.dtos.TweetDto;
import com.ensias.albchometimelineservice.model.User;
import com.ensias.albchometimelineservice.services.homeTimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/feed")
public class HomeTimelineController {
    @Autowired
    homeTimeLineService service;
    @GetMapping("")
    public HttpEntity<List<TweetDto>> getTweetByUser(@RequestParam("userId") Long id){
        return ResponseEntity.ok(service.getUserFeed(id).stream().map(TweetDto::new).collect(Collectors.toList()));
    }

    @GetMapping("/who-follow")
    public HttpEntity<List<User>> getWhoFollow(@RequestParam("userId") Long id){
        return ResponseEntity.ok(service.getOtherUsers(id));
    }

}
