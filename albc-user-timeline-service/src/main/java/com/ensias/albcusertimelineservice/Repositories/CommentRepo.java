package com.ensias.albcusertimelineservice.Repositories;


import com.ensias.albcusertimelineservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
