package com.anuj.project.MovieReviewer.DAO;

import java.util.Map;

import com.anuj.project.MovieReviewer.model.Review;

public interface ReviewsDao {
	public void addReview(Review review) throws Exception;

	public Map<String, Review> getAllReviews();

}
