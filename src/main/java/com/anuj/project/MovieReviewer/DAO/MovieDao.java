package com.anuj.project.MovieReviewer.DAO;

import java.util.Map;

import com.anuj.project.MovieReviewer.model.Movie;

public interface MovieDao {
	public Movie getMovie(int id);

	public Map<Integer, Movie> getAllMovie();

	public void addMovie(Movie movie) throws Exception;

}
