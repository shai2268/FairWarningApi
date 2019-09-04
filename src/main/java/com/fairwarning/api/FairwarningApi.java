package com.fairwarning.api;

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
		SpringApplication.run(FairwarningApi.class, args);
	}

}
