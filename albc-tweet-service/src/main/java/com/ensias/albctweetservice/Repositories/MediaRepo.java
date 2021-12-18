package com.ensias.albctweetservice.Repositories;

import com.ensias.albctweetservice.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepo extends JpaRepository<Media,Long> {
}
