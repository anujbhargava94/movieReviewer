package com.anuj.project.MovieReviewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.project.MovieReviewer.DAOImpl.ResultDao;
import com.anuj.project.MovieReviewer.model.Movie;
import com.anuj.project.MovieReviewer.model.Review;
import com.anuj.project.MovieReviewer.model.User.Reviewer;
import com.anuj.project.MovieReviewer.service.Operations;
import com.google.gson.Gson;

@RestController
@RequestMapping("/")
public class ApplicationController {

	private static String WELCOME = "Welcome to review Application";

	@Autowired
	Operations operation;

	@Autowired
	ResultDao resultDao;

	@RequestMapping(method = RequestMethod.GET, value = "home")
	public String message(@RequestParam("name") String name) {
		String msg = "Hello " + name;
		return msg;
	}

	@RequestMapping(method = RequestMethod.POST, value = "review/add")
	public ResponseEntity createProduct(@RequestBody Review review) {// Welcome page, non-rest

		try {
			operation.addReview(review);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "movie/add")
	public ResponseEntity addMovie(@RequestBody Movie movie) {// Welcome page, non-rest

		try {
			operation.addMovie(movie);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/topMovieYear")
	public String topMovieYear(@RequestParam("name") int year, @RequestParam("type") String reviewerType,
			@RequestParam("top") int top) {

		ResultDao resultDao;
		switch (Reviewer.valueOf(reviewerType)) {
		case VIEWER:
			resultDao = operation.getTopMovieYearViewer(year, top);
			break;
		case CRITIC:
			resultDao = operation.getTopMovieYearCritic(year, top);
			break;
		default:
			resultDao = operation.getTopMovieYearViewer(year, top);
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(resultDao.getResultSet());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topMovieGenre")
	public String topMovieGenre(@RequestParam("name") String genre, @RequestParam("type") String reviewerType,
			@RequestParam("top") int top) {
		ResultDao resultDao;
		switch (Reviewer.valueOf(reviewerType)) {
		case VIEWER:
			resultDao = operation.getTopMovieGenreViewer(genre, top);
			break;
		case CRITIC:
			resultDao = operation.getTopMovieGenreCritic(genre, top);
			break;
		default:
			resultDao = operation.getTopMovieGenreViewer(genre, top);
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(resultDao.getResultSet());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/avgMovieYear")
	public Double avgMovieYear(@RequestParam("year") int year) {
		return operation.getAvgMovieYear(year);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/avgMovieGenre")
	public Double avgMovieGenre(@RequestParam("name") String genre) {
		return operation.getAvgMovieGenre(genre);
	}

}
