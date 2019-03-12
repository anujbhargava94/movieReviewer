package com.anuj.project.MovieReviewer.DAOImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.anuj.project.MovieReviewer.model.User;
import com.anuj.project.MovieReviewer.model.User.Reviewer;

@Service
public class UserDao {

	public Map<Integer, User> users;

	public UserDao() {
		users = new HashMap<>();

		User user1 = new User(1, "U1", Reviewer.VIEWER);
		User user2 = new User(2, "U2", Reviewer.VIEWER);
		User user3 = new User(3, "U3", Reviewer.CRITIC);
		users.put(user1.getId(), user1);
		users.put(user2.getId(), user2);
		users.put(user3.getId(), user3);
	}

	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return users.get(userId);
	}
}
