package com.ensias.albcusertimelineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlbcUserTimelineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbcUserTimelineServiceApplication.class, args);
	}

}
