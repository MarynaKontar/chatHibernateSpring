package ua.goit.offline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.goit.offline.entity.User;
import ua.goit.offline.service.UserService;

/**
 * Created by User on 21.08.2017.
 */
@Controller
@RequestMapping("registration")
public class REgistrationController {
    private final UserService userService;

   @Autowired
    public REgistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String registerUser(@ModelAttribute(name="user") User user){
       userService.save(user);
       return "redirect:/login";
    }
}
