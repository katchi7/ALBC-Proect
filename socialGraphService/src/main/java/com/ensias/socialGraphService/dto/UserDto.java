package com.ensias.socialGraphService.dto;

import com.ensias.socialGraphService.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

	private Long id;
	private String fullName;
    private String email;
    private String userName;
    private String userImage;
	
	public UserDto(User user) {
		this.id = user.getId();
		this.fullName = user.getFullName();
		this.email = user.getEmail();
		this.userName = user.getUserName();
		this.userImage = user.getUserImage();
	}
}
