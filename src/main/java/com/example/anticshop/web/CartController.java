package com.example.anticshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

//    @GetMapping
//    public String getCart(Model model,
//                          Principal principal) {
//
//        model.addAttribute(CART_PRODUCTS, this.orderService.getProductsInTheCart(principal.getName()));
//        model.addAttribute(PRODUCTS_PRICE, this.orderService.getProductsPrice(principal.getName()));
//        model.addAttribute(COUNT_PRODUCTS, this.orderService.getProductsInTheCart(principal.getName()).size());
//
//        return "order-cart";
//    }
//
//    @PatchMapping("/add/{id}")
//    public String addProductToTheCart(@PathVariable("id") Long id,
//                                      Principal principal) {
//
//        cartService.addProductToTheCart(id, principal.getName());
//
//        return "redirect:/menu/" + this.productService.getCategoryName(id);
//    }

}
