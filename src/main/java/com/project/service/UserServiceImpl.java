package com.project.service;

import java.util.List;

import com.project.model.User;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public User getById(Integer id) {
        return userRepository.getById(id);
    }
}
