package com.ensias.albcusertimelineservice.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String fullName;
    private String email;
    private String userName;

}