package com.ensias.socialGraphService.dto;

import java.util.List;

import com.ensias.socialGraphService.entity.User;

import lombok.Data;

@Data
public class FollowersDto {

	private List<UserDto> following;
	private List<UserDto> followers;
}
