package com.example.anticshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class OrderController {

//    @GetMapping()
//    public String cart(Principal username, Model model) {
//        model.addAttribute ("cartCashProduct", this.userService.getChoseListByUserToViewInShoppingCard (username));
//        model.addAttribute ("count", this.userService.countOfItemInCart (username));
//        model.addAttribute ("sumForAllProducts", this.userService.sumForAllPurchaseProduct (username));
//        return "cart";
//    }

}



//    @ModelAttribute("makeOrderDTO")
//    public MakeOrderDTO initMakeOrderDTO() {
//        return new MakeOrderDTO ();
//    }
//
//    @ModelAttribute("messageDTO")
//    public MessageDTO initAddProductDTO() {
//        return new MessageDTO ();
//    }
//
//    @GetMapping("/cart/remove-product-from-list/{id}")
//    String removeProductFromChoseList(@PathVariable("id") Long productId, Principal username) {
//        this.userService.removeProductFromChoseList (productId, username);
//        return "redirect:/cart";
//    }
//
//
//
//    @PatchMapping("/cart")
//    public String cart(Principal username,
//                       @Valid MakeOrderDTO makeOrderDTO,
//                       BindingResult bindingResult,
//                       RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors ()) {
//            redirectAttributes.addFlashAttribute ("makeOrderDTO", makeOrderDTO);
//            redirectAttributes.addFlashAttribute (
//                    "org.springframework.validation.BindingResult.makeOrderDTO", bindingResult);
//
//            return "redirect:/cart";
//        }
//        Long orderId = this.userService.orderProducts (makeOrderDTO, username);
//        return "redirect:/order/details/" + orderId;
//    }