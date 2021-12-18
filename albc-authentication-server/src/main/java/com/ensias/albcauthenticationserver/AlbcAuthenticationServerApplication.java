package com.ensias.albcauthenticationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlbcAuthenticationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbcAuthenticationServerApplication.class, args);
	}

}
