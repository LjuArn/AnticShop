package com.example.anticshop.web;


import com.example.anticshop.domain.bindingModel.ItemBindingModel;
import com.example.anticshop.domain.serviceModel.ItemAddServiceModel;
import com.example.anticshop.service.ItemService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/items")
public class ItemsController {

private final ItemService itemService;
private final ModelMapper modelMapper;

    public ItemsController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/orders/all")
    public String allOrders(Model model){

        model.addAttribute("orders", itemService.getAllOrders());
        return "all-orders";
    }


    @GetMapping("/medals/all")
    public String allMedals(Model model){

        model.addAttribute("medals", itemService.getAllMedals());
        return "all-medals";
    }


    @GetMapping("/coins/all")
    public String allCoinss(Model model){

        model.addAttribute("coins", itemService.getAllCoins());
        return "all-coins";
    }

    @GetMapping("/all")
    public String allItems(Model model) {

        model.addAttribute("items", itemService.findAllItemsViewModel());
        return "all-items";
    }



    @GetMapping("/add")
    public String addRoute(Model model) {
        if (!model.containsAttribute("itemBindingModel")) {
            model.addAttribute("itemBindingModel", new ItemBindingModel());
        }
        return "add-item";
    }


    @PostMapping("/add")
    public String addItem(@Valid ItemBindingModel itemBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("itemBindingModel", itemBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemBindingModel",
                            bindingResult);
            return "redirect:add";

        }

        ItemAddServiceModel itemAddServiceModel = modelMapper.map(itemBindingModel, ItemAddServiceModel.class);

        itemService.addNewItem(itemAddServiceModel);
        return "redirect:all";

    }


    @GetMapping("/details/{id}")
    public String detailsItem(@PathVariable Long id, Model model) {

       model.addAttribute("item", itemService.findByIdItem(id));

        return "details-item";
    }


    @DeleteMapping("/details/{id}")
    public String delete(@PathVariable Long id) {

        itemService.deleteItem(id);
        return "redirect:/items/all";
    }



}
//    @DeleteMapping("/details/{id}")
//    public String delete(@PathVariable Long id,
//                         @AuthenticationPrincipal UserDetails principal) {
//
//        itemService.deleteItem(id);
//        return "redirect:/items/all";
//    }



//    @GetMapping("/edit/{id}")
//    public String getEditProduct(@PathVariable("id") Long productId,
//                                 Model model) {
//
//        model.addAttribute(PRODUCT, this.productService.getProductById(productId));
//
//        return "edit-product";
//    }







//    @GetMapping("/details/{id}")
//    public ModelAndView detailsItem(@PathVariable("id")Long id, ModelAndView modelAndView) {
//
//        modelAndView.addObject("item", this.itemService.findById(id));
//        modelAndView.setViewName("details-item");
//
//        return modelAndView;
//    }
