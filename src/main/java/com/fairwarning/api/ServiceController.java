package com.fairwarning.api;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ServiceController {

	// Atomic long is from util.concurrent and it's long value which gets
	// Automatically updated.
	// it has initial value as 0
	private static final String template = "Welcome %s %s %s \n you are visiting for %d times \n";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "lastName", defaultValue = "") String lastName)
			throws JsonParseException, JsonMappingException, IOException {

		String welcomeAgain = "";

		long currentVisitorCount = 1;

		// create ObjectMapper instance
		// ObjectMapper is used for reading and writing JSON.
		ObjectMapper objectMapper = new ObjectMapper();

		// read json file and convert to customer object
		VisitorsCount visitorsCount = objectMapper.readValue(new File("db.json"), VisitorsCount.class);

		if ((firstName != null && !firstName.trim().isEmpty()) || (lastName != null && !lastName.trim().isEmpty())) {
			Visitor visitor = new Visitor();
			firstName = (firstName != null) ? firstName : "";
			lastName = (lastName != null) ? lastName : "";
			visitor.setUserFirst(firstName);
			visitor.setUserLast(lastName);
			visitor.setId(firstName.toUpperCase() + "_" + lastName.toUpperCase());
			visitor.setVisitCount(1);
			boolean existingVisit = false;
			if (visitorsCount.getVisitors() != null) {
				for (Visitor v1 : visitorsCount.getVisitors()) {
					if (v1.getId().equals(visitor.getId())) {
						existingVisit = true;
						v1.setVisitCount(v1.getVisitCount() + 1);
						currentVisitorCount = v1.getVisitCount();
					}
				}
			} else {
				visitorsCount.setVisitors(new LinkedList<Visitor>());
				visitorsCount.setVisitorsFirstName(new LinkedList<String>());
				visitorsCount.setVisitorsLastName(new LinkedList<String>());
			}
			if (!existingVisit) {
				if (!firstName.isEmpty())
					visitorsCount.getVisitorsFirstName().add(firstName);
				if (!lastName.isEmpty())
					visitorsCount.getVisitorsLastName().add(lastName);
				visitorsCount.getVisitors().add(visitor);
			} else {

				welcomeAgain = "Back";
			}

		}

		// incrementAndGet() : increments the current value by 1 Automatically.
		visitorsCount.setTotalVisits(counter.incrementAndGet());
		objectMapper.writeValue(new File("db.json"), visitorsCount);

		return String.format(template, welcomeAgain, firstName, lastName, currentVisitorCount);
	}

	@RequestMapping("/ping")
	public String ping() {

		return "it_is_working";

	}
	
	@RequestMapping("/")
	public String info() {
		
		String info ="These are other end points :"
				+ "1)http://localhost:8080/greeting"
				+ "2)http://localhost:8080/greeting?firstName=Mohammed&lastName=Askari";
		
		return info;

	}

}
