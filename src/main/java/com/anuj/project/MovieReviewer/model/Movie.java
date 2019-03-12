package com.anuj.project.MovieReviewer.model;

import org.springframework.stereotype.Repository;

@Repository
public class Movie {

	int id;
	String name;
	int year;
	String genre;
	int score;

	public Movie(int id, String name, int year, String genre, int score) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.score = score;
	}

	public Movie(int id, String name, int year, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
	}

	public Movie() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
