package com.example.demo.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ConnectionClass {

	public ConnectionClass()
	{
		caller();
	}
	
	//@Autowired
	RestTemplate resttemplate=new RestTemplate();
	
	public void caller()
	{
		Long start=System.currentTimeMillis();
	ResponseEntity<String> restResponse =	resttemplate.getForEntity("https://developer.spotify.com/", String.class);
	System.out.println(System.currentTimeMillis()-start+" time taken");
	System.out.println(restResponse.getBody().toString());
	}
}
