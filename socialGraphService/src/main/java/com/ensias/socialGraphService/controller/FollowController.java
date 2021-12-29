package com.ensias.socialGraphService.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensias.socialGraphService.dto.FollowUserDto;
import com.ensias.socialGraphService.dto.FollowersDto;
import com.ensias.socialGraphService.dto.OperationResponse;
import com.ensias.socialGraphService.dto.UserDto;
import com.ensias.socialGraphService.entity.User;
import com.ensias.socialGraphService.service.FollowService;

@RestController
@RequestMapping("/socialGraph")
public class FollowController {
	
	@Autowired
	private FollowService followService;

	@PostMapping("/follow")
	public HttpEntity<OperationResponse> followUser(@RequestBody FollowUserDto dto, HttpServletRequest request) {
		followService.followUser(dto.getUserId(), dto.getFollowingId());
		return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(), null,"Follow user",request.getServletPath()));
	}
	
	@DeleteMapping("/unfollow")
	public HttpEntity<OperationResponse> unfollow(@RequestBody FollowUserDto dto, HttpServletRequest request) {
		followService.deleteFollow(dto.getUserId(), dto.getFollowingId());
		return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(), null,"Delete follow",request.getServletPath()));
	}
	
	@GetMapping("/following/{id}")
	public HttpEntity<List<UserDto>> getFollowing(@PathVariable(name = "id") Long id, HttpServletRequest request) {
		return ResponseEntity.ok(followService.getFollowing(id).stream().map(UserDto::new).collect(Collectors.toList()));
	}
	
	@GetMapping("/followers/{id}")
	public HttpEntity<List<UserDto>> getFollowers(@PathVariable(name = "id") Long id, HttpServletRequest request) {
		return ResponseEntity.ok(followService.getFollowers(id).stream().map(UserDto::new).collect(Collectors.toList()));
	}
	
	@GetMapping("/followers-following")
	public HttpEntity<FollowersDto> getFoll(@RequestParam("id") Long id, HttpServletRequest request) {
		List<UserDto> followers = followService.getFollowers(id).stream().map(User::asUserDto).collect(Collectors.toList());
		List<UserDto> following = followService.getFollowing(id).stream().map(User::asUserDto).collect(Collectors.toList());
		FollowersDto dto = new FollowersDto();
		dto.setFollowers(followers);
		dto.setFollowing(following);
		return ResponseEntity.ok(dto);
	}
}
