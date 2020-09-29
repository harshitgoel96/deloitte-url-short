package com.harshit.delloiteUrlShortener.model;

/*
 * 
 * Object to hold input json from the user. This holds the encoded Long User sent by the client. Encoding done on Browser side.
 * */
public class InputObjectHolder {

	private String urlToShortern;

	public String getUrlToShortern() {
		return urlToShortern;
	}

	public void setUrlToShortern(String urlToShortern) {
		this.urlToShortern = urlToShortern;
	}
	
}
