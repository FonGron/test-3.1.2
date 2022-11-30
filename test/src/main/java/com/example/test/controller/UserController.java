package com.example.test.controller;

import com.example.test.model.User;
import com.example.test.service.UserService;
import com.example.test.service.UserServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUser(Model model) {
        model.addAttribute("messages", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", required = true, defaultValue = "") Long id, Model model) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newUser(User user){
        return "form";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit( Model model,@PathVariable("id") long id){
        model.addAttribute("user",userService.readUser(id));
        return "edit";
    }
    @PostMapping({"/edit/{id}"})
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        this.userService.updateUser(user);
        return "redirect:/";
    }
}
