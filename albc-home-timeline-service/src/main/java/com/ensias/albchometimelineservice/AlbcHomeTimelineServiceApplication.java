package com.ensias.albchometimelineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlbcHomeTimelineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbcHomeTimelineServiceApplication.class, args);
	}

}
