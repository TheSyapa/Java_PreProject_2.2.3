package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String showUsers(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/new")
    public String add(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/user_{id}/editUser")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PatchMapping("/user_{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/user_{id}")
    public String remove(@PathVariable("id") int id) {
        userService.remove(id);
        return "redirect:/";
    }
}