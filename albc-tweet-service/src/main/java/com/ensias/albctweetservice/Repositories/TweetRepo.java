package com.ensias.albctweetservice.Repositories;

import com.ensias.albctweetservice.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepo extends JpaRepository<Tweet,Long> {
}
