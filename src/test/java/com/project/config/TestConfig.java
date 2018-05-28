package com.project.config;

import com.project.service.UserServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

public class TestConfig {

    @Bean
    public UserServiceImpl userService() {
        return Mockito.mock(UserServiceImpl.class);
    }
}
