package com.example.anticshop.service;

import com.example.anticshop.domain.serviceModel.ItemAddServiceModel;
import com.example.anticshop.domain.serviceModel.ItemsSummaryInfo;

import java.util.List;

public interface ItemService {
    List<ItemsSummaryInfo> getAllOrders();

    List<ItemsSummaryInfo> getAllMedals();

    List<ItemsSummaryInfo>  getAllCoins();

    void addNewItem(ItemAddServiceModel itemAddServiceModel);
}
