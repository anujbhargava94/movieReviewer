package com.anuj.project.MovieReviewer.serviceImpl;

import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.project.MovieReviewer.DAOImpl.MovieDaoImpl;
import com.anuj.project.MovieReviewer.DAOImpl.ResultDao;
import com.anuj.project.MovieReviewer.DAOImpl.ReviewsDaoImpl;
import com.anuj.project.MovieReviewer.DAOImpl.UserDaoImpl;
import com.anuj.project.MovieReviewer.model.Movie;
import com.anuj.project.MovieReviewer.model.Review;
import com.anuj.project.MovieReviewer.model.User;
import com.anuj.project.MovieReviewer.model.User.Reviewer;
import com.anuj.project.MovieReviewer.service.Operations;

@Service
public class OperationsImpl implements Operations {

	@Autowired
	ResultDao resultDao;

	@Autowired
	MovieDaoImpl movieDao;

	@Autowired
	ReviewsDaoImpl reviewDao;

	@Autowired
	UserDaoImpl userDao;

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMovie(int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review getReview(int reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getAvgMovieYear(int year) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Double result = 0.0;
		int count = 0;
		if (!movieDao.getAllMovie().isEmpty()) {

			for (Map.Entry<Integer, Movie> entry : movieDao.getAllMovie().entrySet()) {
				if (entry.getValue().getYear() == year) {
					result += entry.getValue().getScore();
					count++;
				}
			}
		}

		result = (count > 0) ? result / count : 0.0;
		return result;
	}

	@Override
	public Double getAvgMovieGenre(String genre) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Double result = 0.0;
		int count = 0;
		if (!movieDao.getAllMovie().isEmpty()) {

			for (Map.Entry<Integer, Movie> entry : movieDao.getAllMovie().entrySet()) {
				if (entry.getValue().getGenre().equals(genre)) {
					result += entry.getValue().getScore();
					count++;
				}
			}
		}

		result = (count > 0) ? result / count : 0.0;
		return result;
	}

	@Override
	public ResultDao getTopMovieYearViewer(int year, int top) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		TreeSet<Movie> result = resultDao.getResultSet();
		result.clear();

		if (!reviewDao.getAllReviews().isEmpty()) {

			for (Map.Entry<String, Review> entry : reviewDao.getAllReviews().entrySet()) {
				int movieId = entry.getValue().getMovieId();
				int userId = entry.getValue().getUserId();

				Movie movie = movieDao.getMovie(movieId);
				User user = userDao.getUser(userId);
				if (user != null && movie != null) {
					if (movie.getYear() == year && user.getType().equals(Reviewer.VIEWER)) {
						result.add(movie);
					}
				}
			}
		}

		if (result.size() > top) {
			int count = result.size() - top;
			while (count > 0) {
				result.pollLast();
				count--;
			}
		}

		return resultDao;
	}

	@Override
	public ResultDao getTopMovieYearCritic(int year, int top) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		TreeSet<Movie> result = resultDao.getResultSet();
		result.clear();

		if (!reviewDao.getAllReviews().isEmpty()) {

			for (Map.Entry<String, Review> entry : reviewDao.getAllReviews().entrySet()) {
				int movieId = entry.getValue().getMovieId();
				int userId = entry.getValue().getUserId();

				Movie movie = movieDao.getMovie(movieId);
				User user = userDao.getUser(userId);
				if (user != null && movie != null) {
					if (movie.getYear() == year && user.getType().equals(Reviewer.CRITIC)) {
						result.add(movie);
					}
				}
			}
		}

		if (result.size() > top) {
			int count = result.size() - top;
			while (count > 0) {
				result.pollLast();
				count--;
			}
		}

		return resultDao;
	}

	@Override
	public ResultDao getTopMovieGenreViewer(String genre, int top) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		TreeSet<Movie> result = resultDao.getResultSet();
		result.clear();

		if (!reviewDao.getAllReviews().isEmpty()) {

			for (Map.Entry<String, Review> entry : reviewDao.getAllReviews().entrySet()) {
				int movieId = entry.getValue().getMovieId();
				int userId = entry.getValue().getUserId();

				Movie movie = movieDao.getMovie(movieId);
				User user = userDao.getUser(userId);
				if (user != null && movie != null) {
					if (movie.getGenre().equals(genre) && user.getType().equals(Reviewer.VIEWER)) {
						result.add(movie);
					}
				}
			}
		}
		if (result.size() > top) {
			int count = result.size() - top;
			while (count > 0) {
				result.pollLast();
				count--;
			}
		}
		return resultDao;
	}

	@Override
	public ResultDao getTopMovieGenreCritic(String genre, int top) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		TreeSet<Movie> result = resultDao.getResultSet();
		result.clear();

		if (!reviewDao.getAllReviews().isEmpty()) {

			for (Map.Entry<String, Review> entry : reviewDao.getAllReviews().entrySet()) {
				int movieId = entry.getValue().getMovieId();
				int userId = entry.getValue().getUserId();

				Movie movie = movieDao.getMovie(movieId);
				User user = userDao.getUser(userId);
				if (user != null && movie != null) {
					if (movie.getGenre().equals(genre) && user.getType().equals(Reviewer.CRITIC)) {
						result.add(movie);
					}
				}
			}
		}
		if (result.size() > top) {
			int count = result.size() - top;
			while (count > 0) {
				result.pollLast();
				count--;
			}
		}
		return resultDao;
	}

	@Override
	public void addReview(Review review) {
		// TODO Auto-generated method stub
		try {
			reviewDao.addReview(review);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		try {
			movieDao.addMovie(movie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
