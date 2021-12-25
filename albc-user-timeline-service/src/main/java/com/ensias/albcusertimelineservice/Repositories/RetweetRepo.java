package com.ensias.albcusertimelineservice.Repositories;



import com.ensias.albcusertimelineservice.model.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetweetRepo extends JpaRepository<Retweet,Long> {
}
