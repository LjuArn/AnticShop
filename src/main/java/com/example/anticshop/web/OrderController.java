package com.example.anticshop.web;

import com.example.anticshop.domain.bindingModel.OrderBindingModel;
import com.example.anticshop.service.CartService;
import com.example.anticshop.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final CartService cartService;

    public OrderController(OrderService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @GetMapping("/finalize")
    public String getFinalizeOrder(Model model, Principal principal) {

        if (!model.containsAttribute("orderBindingModel")) {
            model.addAttribute("orderBindingModel", new OrderBindingModel());
        }

        return "order-finalize";
    }


    @PostMapping("/finalize")
    public String postFinalizeOrder(@Valid OrderBindingModel orderBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    Principal principal) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("orderBindingModel", orderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderBindingModel"
                    , bindingResult);

            return "redirect:/orders/finalize";

        }

       orderService.makeOrder(orderBindingModel, principal.getName());

        return "redirect:/items/all";
    }





    @GetMapping("/history")
    public String getUsersOrdersHistory(Model model,
                                      Principal principal) {

        model.addAttribute("orders", orderService.getOrdersByUser(principal.getName()));
        model.addAttribute("itemsPrice", cartService.getItemsPrice(principal.getName()));
        model.addAttribute("countItems",cartService.getItemsInTheCart(principal.getName()).size());

        return "user-orders-history";
    }

//
//    @GetMapping("/all/history")
//    public String getAllOrdersHistory(Model model) {
//
//        model.addAttribute(ALL_ORDERS, this.orderService.getAllOrders());
//
//        return "orders-history";
//    }





}