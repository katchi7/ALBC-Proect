package com.ensias.albcuserService.dtos;

import com.ensias.albcuserService.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationDto extends UserDto {

    @NotNull
    @Size(min = 5,max = 60)
    private String password;
    @NotNull
    @Size(min = 5,max = 60)
    private String confirmPassword;
    public User asUser(){
        return new User(null,super.getFullName(),super.getPhone(),super.getEmail(),super.getUserName(),password,null);
    }
    public boolean passwordValid(){
        return true;
    }
}
