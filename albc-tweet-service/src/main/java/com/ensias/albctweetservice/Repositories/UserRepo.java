package com.ensias.albctweetservice.Repositories;

import com.ensias.albctweetservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
