package com.harshit.delloiteUrlShortener.service;


/*
 * Interface for UrlService. this provides encapsulated actions to user for url shortening service.
 * */
import com.harshit.delloiteUrlShortener.model.UrlDetail;

public interface UrlShortenService {

	//get original url from short url
	public UrlDetail getOriginalUrl(String shortUrl);
	
	//generate and return short url for given long url.
	public UrlDetail generateAndSaveUrl(String encodedUrlToShortern);
	
}
