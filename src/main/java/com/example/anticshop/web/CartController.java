package com.example.anticshop.web;

import com.example.anticshop.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class CartController {


    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String getCart(Model model, Principal principal) {

       model.addAttribute("cartItems", cartService.getItemsInTheCart(principal.getName()));
       model.addAttribute("itemsPrice", cartService.getItemsPrice(principal.getName()));
       model.addAttribute("countItems", cartService.getItemsInTheCart(principal.getName()).size());

        return "cart";
    }

    @PatchMapping("/add/{id}")
    public String addItemsToTheCart(@PathVariable("id") Long id,
                                      Principal principal) {

        cartService.addItemToTheCart(id, principal.getName());

        return "redirect:/items/all";
    }



    @PatchMapping("/remove/{id}")
    public String removeItemFromTheCart(@PathVariable("id") Long id,
                                           Principal principal) {

        this.cartService.removeItemFromTheCart(id, principal.getName());

        return "redirect:/cart";
    }

}
