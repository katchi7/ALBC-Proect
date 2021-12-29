package com.ensias.socialGraphService.dto;

import com.ensias.socialGraphService.entity.Followers;

import lombok.Data;

@Data
public class FollowUserDto {

	private Long id;
	private Long userId;
	private Long followingId;
	
	
}
