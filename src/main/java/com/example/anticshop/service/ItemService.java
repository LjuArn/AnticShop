package com.example.anticshop.service;

import com.example.anticshop.domain.serviceModel.ItemAddServiceModel;
import com.example.anticshop.domain.viewModel.ItemsSummaryInfo;
import com.example.anticshop.domain.viewModel.ItemsViewModel;

import java.util.List;

public interface ItemService {
    List<ItemsSummaryInfo> getAllOrders();

    List<ItemsSummaryInfo> getAllMedals();

    List<ItemsSummaryInfo>  getAllCoins();

    void addNewItem(ItemAddServiceModel itemAddServiceModel);

    List<ItemsViewModel> findAllItemsViewModel();


    ItemsViewModel findByIdItem(Long id);

    void deleteItem(Long id);


    void editItem(Long id, ItemsViewModel itemsViewModel);
}
