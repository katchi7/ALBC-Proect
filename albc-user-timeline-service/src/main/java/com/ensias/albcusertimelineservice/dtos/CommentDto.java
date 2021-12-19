package com.ensias.albcusertimelineservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentDto {

    private Long commentId;
    @NotNull
    @Size(min = 3,max = 500000)
    private String comment;
    @NotNull
    private Long userId;
}
