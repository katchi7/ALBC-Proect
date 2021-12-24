package com.ensias.albchometimelineservice.dtos;


import com.ensias.albchometimelineservice.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentDto {
    public CommentDto(Comment comment){
        this(comment.getCommentId(), comment.getComment(), comment.getUserId());
    }
    private Long commentId;

    private String comment;

    private Long userId;
    public Comment asComment(){
        return new Comment(commentId,comment,userId);
    }
}
