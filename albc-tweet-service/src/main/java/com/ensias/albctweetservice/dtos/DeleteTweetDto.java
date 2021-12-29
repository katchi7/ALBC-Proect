package com.ensias.albctweetservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class DeleteTweetDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long operatorId;
    public boolean validate(){
        return userId==operatorId;
    }
}
