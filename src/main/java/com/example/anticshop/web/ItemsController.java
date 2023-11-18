package com.example.anticshop.web;


import com.example.anticshop.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/orders/all")
    public String all(Model model){

        model.addAttribute("orders", itemService.getAllOrders());
        return "all-orders";
    }

}

