package com.anuj.project.MovieReviewer.DAOImpl;

import java.util.Comparator;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.anuj.project.MovieReviewer.model.Movie;

@Service
public class ResultDao {
	TreeSet<Movie> resultSet;

	public ResultDao() {
		super();

		resultSet = new TreeSet<>(new RatingComparator());
	}

	public TreeSet<Movie> getResultSet() {
		return resultSet;
	}

	public void setResultSet(TreeSet<Movie> resultSet) {
		this.resultSet = resultSet;
	}

	class RatingComparator implements Comparator<Movie> {

		@Override
		public int compare(Movie s1, Movie s2) {
			if (s1.getScore() == s2.getScore())
				return 0;
			else if (s1.getScore() > s2.getScore())
				return 1;
			else
				return -1;
		}

	}

}
