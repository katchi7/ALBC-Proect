package com.ensias.albcusertimelineservice.Repositories;



import com.ensias.albcusertimelineservice.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepo extends JpaRepository<Likes,Long> {
}
