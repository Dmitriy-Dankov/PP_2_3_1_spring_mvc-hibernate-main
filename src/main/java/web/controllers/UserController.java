package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import web.model.User;
import web.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/add")
    public String addUsers(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUsers(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
        if (id < 1) {
            return "redirect:/users";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @PostMapping("/remove")
    public String removeUsers(@RequestParam("id") Long id) {
        if (id < 1) {
            return "redirect:/users";
        }
        userService.removeUser(id);
        return "redirect:/users";
    }
}
