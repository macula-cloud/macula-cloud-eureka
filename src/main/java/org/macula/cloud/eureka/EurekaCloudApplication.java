package org.macula.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCloudApplication.class, args);
	}
}
