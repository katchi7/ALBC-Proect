package com.ensias.albctweetservice.Repositories;

import com.ensias.albctweetservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
