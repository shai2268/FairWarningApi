package com.fairwarning.api;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FairwarningApi {

	public static void main(String[] args) {

		// @springBootApplication:This annotation has inbuilt @componentScan and
		// @EnableAutoConfiguration unlike spring where we have to specify that
		// annotations explicitly
		// *note* : we will be running our program from here as java application. Since
		// SpringBoot has already embedded TomCat Server.
		/* SpringApplication.run(FairwarningApi.class, args); */
		
		 SpringApplication app = new SpringApplication(FairwarningApi.class);
	        app.setDefaultProperties(Collections
	          .singletonMap("server.port", "8080"));    // if you want to change the port number, you can change it here.
	        app.run(args);
	}

}
