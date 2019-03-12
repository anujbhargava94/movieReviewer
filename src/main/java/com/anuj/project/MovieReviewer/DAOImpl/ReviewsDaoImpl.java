package com.anuj.project.MovieReviewer.DAOImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.project.MovieReviewer.DAO.ReviewsDao;
import com.anuj.project.MovieReviewer.model.Movie;
import com.anuj.project.MovieReviewer.model.Review;
import com.anuj.project.MovieReviewer.model.User;
import com.anuj.project.MovieReviewer.model.User.Reviewer;

@Service
public class ReviewsDaoImpl implements ReviewsDao {
	public Map<String, Review> reviews;

	@Autowired
	MovieDaoImpl movies;

	@Autowired
	UserDaoImpl users;

	public ReviewsDaoImpl() {
		reviews = new HashMap<>();

		Review review1 = new Review("1_1", 1, 1, 5);
		Review review2 = new Review("2_1", 2, 1, 8);
		Review review3 = new Review("3_2", 3, 2, 9);
		reviews.put(review1.getId(), review1);
		reviews.put(review2.getId(), review2);
		reviews.put(review3.getId(), review3);
	}

	@Override
	public void addReview(Review review) throws Exception {

		Movie movie = movies.getMovie(review.getMovieId());
		User user = users.getUser(review.getUserId());
		int score = movie.getScore();
		if (movie == null || user == null) {
			throw new Exception("corrupted data");
		}

		if (reviews.containsKey(review.getUserId() + "_" + review.getMovieId())) {
			throw new Exception("Multiple reviews not allowed");
		} else if (movie != null && movie.getYear() > 2019) {
			throw new Exception("Movie yet to be released");
		} else {
			if (user != null && user.getNoReviews() >= 2) {
				user.setType(Reviewer.CRITIC);
				score = score + (review.getRating());
			}
			reviews.put(review.getUserId() + "_" + review.getMovieId(), review);
			int noReview = user.getNoReviews();
			noReview++;
			score += review.getRating();
			movie.setScore(score);
			user.setNoReviews(noReview);

		}
	}

	@Override
	public Map<String, Review> getAllReviews() {
		return reviews;
	}
}
