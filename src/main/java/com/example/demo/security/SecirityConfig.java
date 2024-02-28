package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecirityConfig {

	@Bean
	SecurityFilterChain filter(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/home").permitAll();
			request.anyRequest().authenticated();});
		http.formLogin(form-> {
			form.loginPage("/log").permitAll();
			form.defaultSuccessUrl("/success").permitAll();
			form.failureUrl("/relogin").permitAll();
		});
		http.csrf(csrf->csrf.disable());
		http.logout(logout->{
			logout.logoutSuccessUrl("/home").permitAll();
			logout.deleteCookies("remove");
		});
		return http.build();

	}
}
