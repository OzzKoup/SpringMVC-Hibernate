package com.project.service;

import java.util.List;

import com.project.model.User;

public interface UserService {
	
	User save(User user);

	void delete(User user);

	List<User> getAll();

	void update(User user);

	User getById(Integer id);
}
