package com.harshit.delloiteUrlShortener;

/*
 * Spring boot application class. 
 * 
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.harshit.delloiteUrlShortener.service.UrlShortenService;
import com.harshit.delloiteUrlShortener.service.impl.UrlShortenServiceImpl;

@SpringBootApplication
public class DelloiteUrlShortenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelloiteUrlShortenerApplication.class, args);
	}

	@Bean
	public UrlShortenService urlService() {
		return new UrlShortenServiceImpl();
	}
}
