package com.ensias.albctweetservice.dtos;

import com.ensias.albctweetservice.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentDto {
    public CommentDto(Comment comment){
        this(comment.getCommentId(), comment.getComment(), comment.getUserId());
    }
    private Long commentId;
    @NotNull
    @Size(min = 3,max = 500000)
    private String comment;
    @NotNull
    private Long userId;
    public Comment asComment(){
        return new Comment(commentId,comment,userId);
    }
}
