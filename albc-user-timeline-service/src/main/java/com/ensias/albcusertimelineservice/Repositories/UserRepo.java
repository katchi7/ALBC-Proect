package com.ensias.albcusertimelineservice.Repositories;


import com.ensias.albcusertimelineservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Long> {
}
