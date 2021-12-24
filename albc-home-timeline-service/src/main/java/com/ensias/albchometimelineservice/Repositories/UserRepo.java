package com.ensias.albchometimelineservice.Repositories;

import com.ensias.albchometimelineservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Long> {
}
