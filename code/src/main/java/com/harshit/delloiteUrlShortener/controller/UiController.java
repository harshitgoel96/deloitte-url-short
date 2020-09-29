package com.harshit.delloiteUrlShortener.controller;

/*
 * MVC controller used for presenting UI and Redirect the user when shortened url is hit 
 * 
 * */

import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.harshit.delloiteUrlShortener.model.UrlDetail;
import com.harshit.delloiteUrlShortener.service.UrlShortenService;

@Controller
public class UiController {
	@Autowired
	UrlShortenService urlService;
		
	/*
	 * This end point will open the UI for user.
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	String getUI()
	{
		return "UI";
	}
	
	/*
	 * This end point will check if short url exists, and will redirect the user to new url.
	 * If the short url does not exist 404 header is returned.
	 * */
	@RequestMapping(value="/{shortUrl}", method=RequestMethod.GET)
	public void getOriginalUrlFromShort(@PathVariable("shortUrl")String shortUrl,HttpServletResponse httpServletResponse) {
		System.out.println("getting original model view url for :: "+shortUrl);
		UrlDetail urlDet= urlService.getOriginalUrl(shortUrl);
		if (urlDet!=null)
		{	
			httpServletResponse.setHeader("Location",new String(Base64.getDecoder().decode(urlDet.getOriginalUrl())));
		    httpServletResponse.setStatus(302);
		}
		else
		{
			httpServletResponse.setStatus(404);
		}
		//return null;
		
	}
}
