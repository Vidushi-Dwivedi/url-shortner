package com.urlshortner.url_shortner2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UrlShortner2Application {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortner2Application.class, args);
	}

}
