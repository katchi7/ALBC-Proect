package com.ensias.albchometimelineservice.Repositories;


import com.ensias.albchometimelineservice.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepo extends JpaRepository<Likes,Long> {
}
