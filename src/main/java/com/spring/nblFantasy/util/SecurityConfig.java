package com.spring.nblFantasy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	   @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	   // Statement of the spring config 
	   @Override
	    protected void configure(HttpSecurity http) throws Exception {
		  
		      
	        http.   
	        csrf().disable()
	                .authorizeRequests()
	                .antMatchers("/").permitAll()
	                .antMatchers("/login").permitAll()
	                .antMatchers("/registration").permitAll()
	                .antMatchers("/api/nuevo").permitAll();
	    }
	   @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	                .ignoring()
	                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	        
	    }
	   
	  
	   
	   
}
