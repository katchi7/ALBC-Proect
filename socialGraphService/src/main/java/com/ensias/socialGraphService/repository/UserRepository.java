package com.ensias.socialGraphService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensias.socialGraphService.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
