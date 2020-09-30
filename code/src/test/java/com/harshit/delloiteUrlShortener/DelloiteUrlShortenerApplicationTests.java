package com.harshit.delloiteUrlShortener;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshit.delloiteUrlShortener.model.InputObjectHolder;
import com.harshit.delloiteUrlShortener.model.UrlDetail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class DelloiteUrlShortenerApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate; 
	
	@LocalServerPort
	private int port;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void loadDefaultUI() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Provide URL to Shorten");
	}
	
	@Test
	public void TestRestApi() {
		try {
		String originalUrl="https://www.google.com/";
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    InputObjectHolder input= new InputObjectHolder();
	    input.setUrlToShortern(Base64.getEncoder().encodeToString(originalUrl.getBytes("UTF-8")));
	    ObjectMapper Obj = new ObjectMapper();
	    String inputJson;
		
			inputJson = Obj.writeValueAsString(input);
		
	    HttpEntity<String> request = 
	    	      new HttpEntity<String>(inputJson, headers);
	    UrlDetail responseObject=this.restTemplate.postForObject("http://localhost:" + port + "/shorternUrl", request, UrlDetail.class);
	    String shortKey=responseObject.getShortenUrl();
	    
	    ResponseEntity<String> respEty=this.restTemplate.getForEntity("http://localhost:" + port + "/"+shortKey,String.class);
//	    int retCode=respEty.getStatusCodeValue();
	    HttpHeaders respHead=respEty.getHeaders();
	   String newLoc= respHead.getLocation().toString();
	   //System.out.println();
	    //assertThat(retCode==302);
	    assertThat(newLoc.equals(originalUrl));
	  
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
