package com.ensias.socialGraphService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ensias.socialGraphService.entity.Followers;
import com.ensias.socialGraphService.entity.User;

@Repository
public interface FollowersRepository extends JpaRepository<Followers, Long> {

	@Query("Select f from Followers as f where f.from.id = ?1 and f.to.id = ?2")
	Followers getFollow(Long idUser, Long idFollowing);
	
}
