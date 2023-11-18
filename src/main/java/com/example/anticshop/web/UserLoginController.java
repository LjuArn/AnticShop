package com.example.anticshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    @GetMapping("/login")
    public String loginUser() {
        return "login";
    }


    @PostMapping("/login-error")
    public String onFailure( @ModelAttribute("username") String username,Model model){

        model.addAttribute("username", username);
        model.addAttribute("badCredentials", true);

        return "login";
    }

}







//    @PostMapping("/login-error")
//    public String onFailure(
//            @ModelAttribute("email") String email,
//            Model model) {
//
//        model.addAttribute("email", email);
//        model.addAttribute("bad_credentials", "true");
//
//        return "auth-login";
//    }