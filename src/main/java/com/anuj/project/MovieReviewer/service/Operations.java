package com.anuj.project.MovieReviewer.service;

import org.springframework.stereotype.Service;

import com.anuj.project.MovieReviewer.DAOImpl.ResultDao;
import com.anuj.project.MovieReviewer.model.Movie;
import com.anuj.project.MovieReviewer.model.Review;
import com.anuj.project.MovieReviewer.model.User;

@Service
public interface Operations {

	public void addReview(Review review);

	public User getUser(int userId);

	public Movie getMovie(int movieId);

	public Review getReview(int reviewId);

	public ResultDao getTopMovieYearViewer(int year, int top);

	public ResultDao getTopMovieYearCritic(int year, int top);

	public ResultDao getTopMovieGenreViewer(String genre, int top);

	public ResultDao getTopMovieGenreCritic(String genre, int top);

	public Double getAvgMovieYear(int year);

	public Double getAvgMovieGenre(String genre);

	public void addMovie(Movie movie);

}
