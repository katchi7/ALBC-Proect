package com.ensias.albcauthenticationserver.dtos;


import com.ensias.albcauthenticationserver.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    public UserDto(User user){
        this(user.getId(),user.getFullName(),user.getCreatedAt(),user.getPhone(),user.getEmail(),user.getUserName(), user.getUserImage(),null);
    }
    private Long id;

    private String fullName;
    private Date createdAt;
    private String phone;

    private String email;

    private String userName;
    private String userImage;
    private String token;
    public boolean validId(){
        return id!=null;
    }
    public User asUser(){
        return new User(id,fullName,createdAt,phone,email,userName,null,null,userImage);
    }
}
