package com.ensias.socialGraphService.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ensias.socialGraphService.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	@Id
	private Long id;
	private String fullName;
    private String email;
    private String userName;
    private String userImage;
	
	@OneToMany(mappedBy = "from",targetEntity = Followers.class)
	private List<Followers> following;
	
	@OneToMany(mappedBy = "to",targetEntity = Followers.class)
	private List<Followers> followers;
	
	public UserDto asUserDto() {
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setEmail(email);
		dto.setFullName(fullName);
		dto.setUserImage(userImage);
		dto.setUserName(userName);
		return dto;
	}
}
