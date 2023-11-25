package com.example.anticshop.web;


import com.example.anticshop.domain.bindingModel.ItemBindingModel;
import com.example.anticshop.domain.serviceModel.ItemAddServiceModel;
import com.example.anticshop.domain.viewModel.ItemsViewModel;
import com.example.anticshop.service.ItemService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String allOrders(Model model) {

        model.addAttribute("orders", itemService.getAllOrders());
        return "all-orders";
    }


    @GetMapping("/medals/all")
    public String allMedals(Model model) {

        model.addAttribute("medals", itemService.getAllMedals());
        return "all-medals";
    }


    @GetMapping("/coins/all")
    public String allCoinss(Model model) {

        model.addAttribute("coins", itemService.getAllCoins());
        return "all-coins";
    }

    @GetMapping("/all")
    public String allItems(Model model) {

        model.addAttribute("items", itemService.findAllItemsViewModel());
        return "all-items";
    }


    @GetMapping("/add")
    public String addItemGet(Model model) {
        if (!model.containsAttribute("itemBindingModel")) {
            model.addAttribute("itemBindingModel", new ItemBindingModel());
        }
        return "add-item";
    }


    @PostMapping("/add")
    public String addItemPost(@Valid ItemBindingModel itemBindingModel,
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

    @GetMapping("/edit/{id}")
    public String getEditItem(@PathVariable("id") Long id, Model model) {

        model.addAttribute("editedItem", itemService.findByIdItem(id));

        return "edit-item";
    }




    @PatchMapping("/edit/{id}")
    public String editItem(@PathVariable("id") Long id,
                           @Valid ItemsViewModel itemsViewModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("itemsViewModel", itemsViewModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemsViewModel", bindingResult);

            return "redirect:edit/{id}";

        }

        itemService.editItem(id, itemsViewModel);

        return "redirect:/items/orders/all";
    }


}


