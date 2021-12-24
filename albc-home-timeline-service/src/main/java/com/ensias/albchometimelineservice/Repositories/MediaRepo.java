package com.ensias.albchometimelineservice.Repositories;


import com.ensias.albchometimelineservice.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepo extends JpaRepository<Media,Long> {
}
