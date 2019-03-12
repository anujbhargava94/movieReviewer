package com.anuj.project.MovieReviewer.model;

import org.springframework.stereotype.Repository;

@Repository
public class User {

	String name;
	Reviewer type;
	int id;
	int noReviews;

	public enum Reviewer {
		VIEWER, CRITIC
	}

	public User(int id, String name, Reviewer type) {
		super();
		this.name = name;
		this.type = type;
		this.id = id;
	}

	public User() {
		super();
	}

	public int getNoReviews() {
		return noReviews;
	}

	public void setNoReviews(int noReviews) {
		this.noReviews = noReviews;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Reviewer getType() {
		return type;
	}

	public void setType(Reviewer type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
