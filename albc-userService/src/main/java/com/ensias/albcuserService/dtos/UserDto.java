package com.ensias.albcuserService.dtos;

import com.ensias.albcuserService.model.User;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public UserDto(User user){
        this(user.getId(),user.getFullName(),user.getPhone(),user.getEmail(),user.getUserName(), user.getUserImage(),user.getCreatedAt(),user.getDob());
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
    private Date createdAt;
    private Date dob;
    @JsonSetter("dob")
    public void dobSetter(String dobstr)  {
        try {
            dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobstr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public boolean validId(){
        return id!=null;
    }
}
