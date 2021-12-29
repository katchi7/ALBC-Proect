package com.ensias.albcauthenticationserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String fullName;
    private Date createdAt;
    private String phone;
    private String email;
    private String userName;
    private String password;
    private Boolean accountActivated;
    private String userImage;

}
