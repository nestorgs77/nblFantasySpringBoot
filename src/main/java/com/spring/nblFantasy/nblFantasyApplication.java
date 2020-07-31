package com.spring.nblFantasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.spring.nblFantasy.views.resources"})
public class nblFantasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(nblFantasyApplication.class, args);
	}

}
