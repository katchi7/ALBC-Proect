package com.ensias.albctweetservice.Repositories;

import com.ensias.albctweetservice.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepo extends JpaRepository<Likes,Long> {
}
