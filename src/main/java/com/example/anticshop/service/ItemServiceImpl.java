package com.example.anticshop.service;

import com.example.anticshop.domain.enums.CategoryNameEnum;
import com.example.anticshop.domain.serviceModel.OrderSummeryInfo;
import com.example.anticshop.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderSummeryInfo> getAllOrders() {
         return
                itemRepository
                .findByCategory_Name(CategoryNameEnum.ORDERS)
                .stream()
                .map(itemEntity -> {
                    OrderSummeryInfo orderSummeryInfo = modelMapper.map(itemEntity, OrderSummeryInfo.class);
               return orderSummeryInfo;
                })
                .collect(Collectors.toList());

    }
}



//        List<OfferSummeryModel> test = offerRepository
//                .findAll()
//                .stream()
//                .map(offerEntity -> {
//                    OfferSummeryModel offerSummeryModel = modelMapper.map(offerEntity, OfferSummeryModel.class);
//                    offerSummeryModel.setModel(offerEntity.getModel().getName());
//                    offerSummeryModel.setBrand(offerEntity.getModel().getBrand().getName());
//                    return offerSummeryModel;
//                })
//                .collect(Collectors.toList());
//
//        return test;