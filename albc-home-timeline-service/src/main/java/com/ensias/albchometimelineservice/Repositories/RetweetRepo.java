package com.ensias.albchometimelineservice.Repositories;


import com.ensias.albchometimelineservice.model.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetweetRepo extends JpaRepository<Retweet,Long> {
}
