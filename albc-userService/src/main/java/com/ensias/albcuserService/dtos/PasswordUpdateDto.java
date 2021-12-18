package com.ensias.albcuserService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PasswordUpdateDto {
    @NotNull
    private Long id;
    @NotNull
    @Size(min = 5)
    private String oldPassword;
    @NotNull
    @Size(min = 5)
    private String newPassword;
    @NotNull
    @Size(min = 5)
    private String confirmPassword;
    public boolean passwordValid(){
        return (confirmPassword!=null && confirmPassword.equals(newPassword));
    }
}
