package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.connector.ConnectionClass;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String defaultMethod() {
		System.out.println("Entered home2 method");
		return "home2";
	}
	
	@GetMapping("/home")
	public String getMethodName() {
		System.out.println("Entered home method");
		return "home";
	}
	
	@GetMapping("/log")
	public String getLogin() {
		return "log";
	}
	
	@GetMapping("/success")
	public String getErrorr() {
		System.out.println("Entered success page");
		//System.out.println(new ConnectionClass());
		RestTemplate resttemplate=new RestTemplate();
		//return "success";
		return (resttemplate.getForEntity("https://developer.spotify.com/", String.class).getBody().toString())+".html";
	}
	
	@GetMapping("/relogin")
	public String reLogin() {
		System.out.println("Entered home2 method");
		return "relogin";
	}
	
}
