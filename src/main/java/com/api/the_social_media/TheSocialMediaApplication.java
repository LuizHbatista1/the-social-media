package com.api.the_social_media;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:.env")
public class TheSocialMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheSocialMediaApplication.class, args);
	}

}
