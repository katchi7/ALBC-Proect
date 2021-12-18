package com.ensias.albcuserService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotNull
    @Size(min = 5)
    private String login;
    @NotNull
    @Size(min = 5)
    private String password;
}
