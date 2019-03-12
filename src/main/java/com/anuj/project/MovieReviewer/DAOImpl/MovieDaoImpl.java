package com.anuj.project.MovieReviewer.DAOImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.anuj.project.MovieReviewer.DAO.MovieDao;
import com.anuj.project.MovieReviewer.model.Movie;

@Service
public class MovieDaoImpl implements MovieDao {
	private Map<Integer, Movie> movies;

	public MovieDaoImpl() {
		movies = new HashMap<>();

		Movie movie1 = new Movie(1, "A", 2001, "G1", 5);
		Movie movie2 = new Movie(2, "B", 2010, "G2", 10);
		Movie movie3 = new Movie(3, "C", 2020, "G3", 23);
		movies.put(movie1.getId(), movie1);
		movies.put(movie2.getId(), movie2);
		movies.put(movie3.getId(), movie3);
	}

	@Override
	public Movie getMovie(int id) {
		return movies.get(id);
	}

	@Override
	public Map<Integer, Movie> getAllMovie() {
		return movies;
	}

	@Override
	public void addMovie(Movie movie) throws Exception {
		if (movie.getId() > 0 && !movies.containsKey(movie.getId())) {
			movies.put(movie.getId(), movie);
		} else {
			throw new Exception("Corrupted data");
		}
	}

}
