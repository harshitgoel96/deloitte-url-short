package com.harshit.delloiteUrlShortener.controller;

/*
 * Rest controller used providing an api to allow shortening of URL via REST call
 * 
 * */

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.harshit.delloiteUrlShortener.model.InputObjectHolder;
import com.harshit.delloiteUrlShortener.model.UrlDetail;
//import com.harshit.delloiteUrlShortener.repo.ShortUrlRepo;
import com.harshit.delloiteUrlShortener.service.UrlShortenService;


@RestController
public class UrlShortenCtrl {

	@Autowired
	UrlShortenService urlService;
		
	/*
	 * This is the rest end point used to provide a short url inplace of encoded long url entered by the user.
	 * */
	
	@RequestMapping(value="/shorternUrl", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	UrlDetail shorternUrl(
			@RequestBody InputObjectHolder encodedUrlToShortern
			) {
		System.out.println("request recieved");
		return urlService.generateAndSaveUrl(encodedUrlToShortern.getUrlToShortern());
	}
	
	
}
