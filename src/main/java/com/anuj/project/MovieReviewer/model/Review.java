package com.anuj.project.MovieReviewer.model;

import org.springframework.stereotype.Repository;

@Repository
public class Review {

	int userId;
	int movieId;
	int rating;
	String id;

	public Review(String id, int userId, int movieId, int rating) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
		this.id = id;
	}

	public Review(int userId, int movieId, int rating) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}

	public Review() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
