package com.ensias.albctweetservice.Repositories;

import com.ensias.albctweetservice.model.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetweetRepo extends JpaRepository<Retweet,Long> {
}
