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
public class UserDto {
    public UserDto(User user){
        this(user.getId(),user.getFullName(),user.getPhone(),user.getEmail(),user.getUserName(), user.getUserImage());
    }
    private Long id;
    @NotNull
    @Size(min = 5,max = 60)
    private String fullName;
    @NotNull
    @Size(min = 5,max = 60)
    private String phone;
    @NotNull
    @Size(min = 5,max = 60)
    private String email;
    @NotNull
    @Size(min = 3,max = 60)
    private String userName;
    private String userImage;
    public boolean validId(){
        return id!=null;
    }
}
