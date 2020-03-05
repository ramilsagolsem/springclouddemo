package com.odyssey.app.api.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OdysseyAppApiDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdysseyAppApiDiscoveryServiceApplication.class, args);
	}

}
