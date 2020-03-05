package com.odyssey.app.api.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class OdysseyAppApiConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdysseyAppApiConfigServerApplication.class, args);
	}

}
