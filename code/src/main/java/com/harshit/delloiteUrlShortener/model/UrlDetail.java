package com.harshit.delloiteUrlShortener.model;

/*
 * This class holds the short url data. Shorten url is basically the 10 char key used to identify the long url in db.
 * */

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class UrlDetail {
	
	//unique id
	String id;
	
	//encoded original url
	String originalUrl;
	
	//system generated short url
	String shortenUrl;
	
	//could be used for data clean up
	Date timeOfExpiry;
	
	public UrlDetail() {}
	
	public UrlDetail(String id, String originalUrl, String shortenUrl, Date timeOfExpiry) {
		super();
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortenUrl = shortenUrl;
		this.timeOfExpiry = timeOfExpiry;
		
	}
	public UrlDetail(String originalUrl, String shortenUrl) {
		super();
		this.originalUrl = originalUrl;
		this.shortenUrl = shortenUrl;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getShortenUrl() {
		return shortenUrl;
	}
	public void setShortenUrl(String shortenUrl) {
		this.shortenUrl = shortenUrl;
	}
	public Date getTimeOfExpiryUTC() {
		return timeOfExpiry;
	}
	public void setTimeOfExpiryUTC(Date timeOfExpiry) {
		this.timeOfExpiry = timeOfExpiry;
	}
	

}
