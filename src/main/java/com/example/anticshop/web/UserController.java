package com.example.anticshop.web;


import com.example.anticshop.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

//    @GetMapping("/register")
//    public String register(Model model) {
//
//        if (!model.containsAttribute("userRegisterBindingModel")) {
//            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
//        }
//        return "auth-register";
//    }
//
//    @PostMapping("/register")
//    public String registerConfirmPost(@Valid UserRegisterBindingModel userRegisterBindingModel,
//                                      BindingResult bindingResult,
//                                      RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors() ||
//                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())
//        ) {
//            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
//            return "redirect:register";
//        }
//
//        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
//
//        return "redirect:login";
//    }


    //-------------------------------------------------
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