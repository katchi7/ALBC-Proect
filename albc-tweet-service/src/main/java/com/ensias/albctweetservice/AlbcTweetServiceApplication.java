package com.ensias.albctweetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlbcTweetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbcTweetServiceApplication.class, args);
	}

}
