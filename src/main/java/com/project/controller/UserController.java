package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.User;
import com.project.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private User user = new User();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrderPage(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPage() {
        return "createUser";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(value = "name") String name,
                         @RequestParam(value = "surname") String surname,
                         @RequestParam(value = "country") String country,
                         @RequestParam(value = "email") String email) {
        user.setName(name);
        user.setSurname(surname);
        user.setCountry(country);
        user.setEmail(email);
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "delete") int id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String showValues(Model model, @RequestParam(value = "userId") int id) {
        String visible = "visible";
        List<User> users = userService.getAll();
        User user = userService.getById(id);
        model.addAttribute("updateUser", user);
        model.addAttribute("users", users);
        model.addAttribute("visible", visible);
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam(value = "name") String name,
                         @RequestParam(value = "surname") String surname,
                         @RequestParam(value = "country") String country,
                         @RequestParam(value = "email") String email,
                         @RequestParam(value = "id") Integer id) {
        user.setId(id);
        user.setName(name);
        user.setSurname(surname);
        user.setCountry(country);
        user.setEmail(email);
        userService.update(user);
        return "redirect:/";
    }
}
