package com.ensias.albchometimelineservice.Repositories;


import com.ensias.albchometimelineservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
