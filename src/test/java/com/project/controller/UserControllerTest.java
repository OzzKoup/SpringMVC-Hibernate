package com.project.controller;

import com.project.config.PersistentConfig;
import com.project.model.User;
import com.project.service.UserServiceImpl;
import com.project.config.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {PersistentConfig.class, TestConfig.class})
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext applicationContext;

    @Autowired
    UserServiceImpl userService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void testCorrectValuesAndAmountRetuningByGetAllMethod() throws Exception {
        User user1 = new User();
        user1.setName("Test1");
        user1.setSurname("Test1");
        user1.setCountry("Test1");
        user1.setEmail("test1@test.com");

        User user2 = new User();
        user2.setName("Test2");
        user2.setSurname("Test2");
        user2.setCountry("Test2");
        user2.setEmail("test2@test.com");

        when(userService.getAll()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("users", hasSize(2)))
                .andExpect(model().attribute("users", hasItem(
                        allOf(
                                hasProperty("name", is("Test1")),
                                hasProperty("email", is("test1@test.com")))
                )))
                .andExpect(model().attribute("users", hasItem(
                        allOf(
                                hasProperty("name", is("Test2")),
                                hasProperty("email", is("test2@test.com")))
                )));
    }

    @Test
    public void testReturningCorrectJspForDefaultUrl() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));

    }
    @Test
    public void testReturningCorrectJspForCreateUrl() throws Exception {
        mockMvc.perform(get("/create"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/views/createUser.jsp"));

    }
}