package com.project.repository;

import java.util.List;

import com.project.model.User;

public interface UserRepository {

	User save(User user);
	
	void delete(User user);
	
	List<User> getAll();

	void update(User user);
	
	User getById(Integer id);
}
