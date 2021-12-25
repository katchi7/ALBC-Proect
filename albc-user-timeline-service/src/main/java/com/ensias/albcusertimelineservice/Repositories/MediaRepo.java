package com.ensias.albcusertimelineservice.Repositories;



import com.ensias.albcusertimelineservice.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepo extends JpaRepository<Media,Long> {
}
