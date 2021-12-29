package com.ensias.socialGraphService.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensias.socialGraphService.api.UserServiceApi;
import com.ensias.socialGraphService.dto.FollowersDto;
import com.ensias.socialGraphService.dto.UserDto;
import com.ensias.socialGraphService.entity.Followers;
import com.ensias.socialGraphService.entity.User;
import com.ensias.socialGraphService.exceptions.FollowUserExist;
import com.ensias.socialGraphService.exceptions.NotFoundUser;
import com.ensias.socialGraphService.repository.FollowersRepository;
import com.ensias.socialGraphService.repository.UserRepository;

@Service
public class FollowService {

	@Autowired
	private FollowersRepository followersRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServiceApi userService;

	public void followUser(Long idUser, Long idFollowing) {
		Followers checkFollowers = followersRepository.getFollow(idUser, idFollowing);
		if(checkFollowers == null) {
			User from = userRepository.findById(idUser).orElseThrow();
			User to = userRepository.findById(idFollowing).orElseThrow();
			Followers followers = new Followers();
			followers.setFrom(from);
			followers.setTo(to);
			followersRepository.save(followers);
		}
		else {
			throw new FollowUserExist("User already follows this account");
		}
		
	}

	public void deleteFollow(Long idUser, Long idFollowing) {
		Followers followers = followersRepository.getFollow(idUser, idFollowing);
		followersRepository.delete(followers);
	}

	public List<User> getFollowing(Long idUser) {
		try {
			User user = userRepository.findById(idUser).orElseThrow();
			List<Followers> following = user.getFollowing();
			List<User> users = following.stream().map(Followers::getTo).collect(Collectors.toList());
			return users;
		} catch (NoSuchElementException ex) {
			throw new NotFoundUser("User doesn't exist");
		}
		
	}

	public List<User> getFollowers(Long idUser) {
		try {
			User user = userRepository.findById(idUser).orElseThrow();
			List<Followers> followers = user.getFollowers();
			List<User> users = followers.stream().map(Followers::getFrom).collect(Collectors.toList());
			return users;
		} catch (NoSuchElementException ex) {
			throw new NotFoundUser("User doesn't exist");
		}

	}

}
