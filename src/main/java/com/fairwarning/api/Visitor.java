package com.fairwarning.api;

public class Visitor {

	private String id;

	private long visitCount;

	private String userFirst;

	private String userLast;

	public long getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(long visitCount) {
		this.visitCount = visitCount;
	}

	public String getUserFirst() {
		return userFirst;
	}

	public void setUserFirst(String userFirst) {
		this.userFirst = userFirst;
	}

	public String getUserLast() {
		return userLast;
	}

	public void setUserLast(String userLast) {
		this.userLast = userLast;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
