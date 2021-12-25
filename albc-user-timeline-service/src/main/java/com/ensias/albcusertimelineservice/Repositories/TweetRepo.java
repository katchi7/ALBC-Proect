package com.ensias.albcusertimelineservice.Repositories;


import com.ensias.albcusertimelineservice.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepo extends JpaRepository<Tweet,Long> {
    List<Tweet> findTweetByUserId(Long userId);
}
