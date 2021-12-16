package com.ensias.albcregistryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AlbcRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbcRegistryServerApplication.class, args);
	}

}
