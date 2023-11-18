package com.example.anticshop.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {


    @GetMapping("/all")
    public String allUsers(Model model){

      //  model.addAttribute("users", );
        return "all-users";
    }

}


//offerService.getAllOffersNow()