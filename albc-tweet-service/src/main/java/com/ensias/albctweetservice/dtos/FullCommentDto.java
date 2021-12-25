package com.ensias.albctweetservice.dtos;

import com.ensias.albctweetservice.model.Comment;
import com.ensias.albctweetservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FullCommentDto extends CommentDto {
    public FullCommentDto(Comment comment){
        super(comment);
    }
    private User user;
    public Comment asComment(){
        return super.asComment();
    }
}
