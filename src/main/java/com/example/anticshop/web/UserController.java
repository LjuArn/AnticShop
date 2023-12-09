package com.example.anticshop.web;


import com.example.anticshop.domain.serviceModel.UserServiceModel;
import com.example.anticshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String allUsers(Model model){

        model.addAttribute("users", userService.getAllUsers() );
        return "users-all";
    }


    @GetMapping("/change/{id}")
    public String getChangeRoles(@PathVariable("id") Long id,
                                 UserServiceModel userChangeStatus,
                                 Model model) {

        model.addAttribute("users", userService.editUserStatus(id,userChangeStatus));

        return "redirect:/users/all";

    }


}

