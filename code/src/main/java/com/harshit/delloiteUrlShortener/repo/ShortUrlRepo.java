package com.harshit.delloiteUrlShortener.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.harshit.delloiteUrlShortener.model.UrlDetail;

/*
 * Repository for CRUD operation on URL detail.
 * 
 * */
@Repository
public class ShortUrlRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public UrlDetail getByShortUrl(String shortUrl) {
		try {
			System.out.println("running query for "+shortUrl);
		return jdbcTemplate.queryForObject("select * from UrlDetail where shortenUrl=?", new Object[] { shortUrl },
				new BeanPropertyRowMapper<UrlDetail>(UrlDetail.class));
		}
		catch(Exception e) {e.printStackTrace();return null;}
	}

	public int insert(UrlDetail urlToShort) {
		System.out.println("trying to insert record");
		return jdbcTemplate.update("insert into UrlDetail ( originalUrl, shortenUrl,timeOfExpiry) " + "values(?,  ?, current_date+365)",
				new Object[] {  urlToShort.getOriginalUrl(), urlToShort.getShortenUrl() });
	}
	
	public boolean isUnique(String shortUrl) {
		Integer count=jdbcTemplate.queryForObject("select count(*) from UrlDetail where shortenUrl=?", Integer.class,shortUrl);
		return (count.intValue()>0)?false:true;
	}
}
