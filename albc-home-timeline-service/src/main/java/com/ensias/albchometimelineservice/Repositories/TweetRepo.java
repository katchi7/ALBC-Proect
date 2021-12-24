package com.ensias.albchometimelineservice.Repositories;


import com.ensias.albchometimelineservice.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepo extends JpaRepository<Tweet,Long> {
}
