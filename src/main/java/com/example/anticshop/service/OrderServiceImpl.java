package com.example.anticshop.service;

import com.example.anticshop.domain.bindingModel.OrderBindingModel;
import com.example.anticshop.domain.entity.OrderEntity;
import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.entity.enums.OrderConditionEnum;
import com.example.anticshop.domain.viewModel.OrderViewModel;
import com.example.anticshop.repository.OrderRepository;
import com.example.anticshop.service.exeption.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(UserService userService, OrderRepository orderRepository, ModelMapper modelMapper) {
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void makeOrder(OrderBindingModel orderBindingModel, String userName) {

        OrderEntity order = new OrderEntity();
        UserEntity user = userService.getUserByUsername(userName);
        buildOrder(order, user, orderBindingModel);

        order.setSumItemsOrder(user.getCart().getItemsSum());
        orderRepository.saveAndFlush(order);

    }


    private static void buildOrder(OrderEntity order, UserEntity user, OrderBindingModel orderBindingModel) {
        order
                .setUser(user)
                .setCart(user.getCart())
                .setDateOrdered(LocalDateTime.now())
                .setOrderCondition(OrderConditionEnum.READY_FOR_SENT)
                .setAddress(orderBindingModel.getAddress())
                .setGsm(orderBindingModel.getGsm());
    }


    @Override
    public List<OrderViewModel> getOrdersByUser(String username) {
        UserEntity user = userService.getUserByUsername(username);

        return orderRepository.
                findAllByUser_Id(user.getId())
                .stream()
                .map(orderEntity -> modelMapper.map(orderEntity, OrderViewModel.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<OrderViewModel> getAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(orderEntity -> modelMapper.map(orderEntity, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void finishOrder(Long orderId) {
        OrderEntity orderEntity = this.orderRepository
                .findById(orderId)
                .orElseThrow(()-> new ObjectNotFoundException("Order with" + orderId + "not found"));


        orderEntity.setOrderCondition(OrderConditionEnum.DELIVERED);
        orderEntity.setDeliveredOn(LocalDateTime.now());

        this.orderRepository.saveAndFlush(orderEntity);
    }


}
