package com.ensias.albcuserService.repos;

import com.ensias.albcuserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT u from User as u where u.email=?1 or u.userName=?1 or u.phone=?1")
    List<User> findUserByLogin(String login);
}
