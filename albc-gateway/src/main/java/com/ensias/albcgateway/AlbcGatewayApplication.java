package com.ensias.albcgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlbcGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbcGatewayApplication.class, args);
	}

}
