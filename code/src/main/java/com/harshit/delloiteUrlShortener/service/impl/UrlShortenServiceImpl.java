package com.harshit.delloiteUrlShortener.service.impl;


/*
 * The implementation class of UrlShortenService. This contains the major business logic used to make the url shortening work
 * 
 * We generate a random 10 char long string, and associate that with the provided url. We then store it in database.
 * 
 * We retrieve the original character from database when Short Url Key is provided. This is a simple select query in database.
 * */
import org.springframework.beans.factory.annotation.Autowired;

import com.harshit.delloiteUrlShortener.model.UrlDetail;
import com.harshit.delloiteUrlShortener.repo.ShortUrlRepo;
import com.harshit.delloiteUrlShortener.service.UrlShortenService;

public class UrlShortenServiceImpl implements UrlShortenService {

	@Autowired
	ShortUrlRepo urlRepo;

	@Override
	public UrlDetail getOriginalUrl(String shortUrl) {
		//Find and return url
		return urlRepo.getByShortUrl(shortUrl);
	}

	@Override
	public UrlDetail generateAndSaveUrl(String encodedUrlToShortern) {
		
		//Generate new unique short url
		String shortUrl = "";
		do {
			shortUrl = getShortString();
		} while (!isShortStringUnique(shortUrl));
		System.out.println("new short url  "+shortUrl);
		//create object with new short url and encoded long url
		UrlDetail detail = new UrlDetail(encodedUrlToShortern, shortUrl);
		
		//insert into repo
		urlRepo.insert(detail);
		UrlDetail newData= urlRepo.getByShortUrl(shortUrl);
		System.out.println("new data queried");
		//query and return recently created data
		return newData;
	}

	private boolean isShortStringUnique(String shortUrl) {
		//check if URL already exists or not
		return urlRepo.isUnique(shortUrl);
	}

	private String getShortString() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString 
		StringBuilder sb = new StringBuilder(10);

		for (int i = 0; i < 10; i++) {

			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb 
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

}
