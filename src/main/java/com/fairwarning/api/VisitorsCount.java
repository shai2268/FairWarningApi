package com.fairwarning.api;

import java.util.List;

public class VisitorsCount {

	private long totalVisits;

	private List<String> visitorsFirstName;

	private List<String> visitorsLastName;

	private List<Visitor> visitors;

	// @gets the total count of visits.
	public long getTotalVisits() {
		return totalVisits;
	}

	// @sets the total count of visits.
	public void setTotalVisits(long totalVisits) {
		this.totalVisits = totalVisits;
	}

	// @gets the list of Visitors firstName
	public List<String> getVisitorsFirstName() {
		return visitorsFirstName;
	}

	// @sets the list of Visitors firstName
	public void setVisitorsFirstName(List<String> visitorsFirstName) {
		this.visitorsFirstName = visitorsFirstName;
	}

	// @gets the list of Visitors lastName
	public List<String> getVisitorsLastName() {
		return visitorsLastName;
	}

	// @sets the list of Visitors lastName
	public void setVisitorsLastName(List<String> visitorsLastName) {
		this.visitorsLastName = visitorsLastName;
	}

	// @gets the list of visitor Pojo(Visitor.java)
	public List<Visitor> getVisitors() {
		return visitors;
	}

	// @sets the list of Visitor pojo.
	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}

}
