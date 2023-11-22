package com.example.anticshop.service;

import com.example.anticshop.domain.entity.ItemEntity;
import com.example.anticshop.domain.entity.enums.CategoryNameEnum;
import com.example.anticshop.domain.serviceModel.ItemAddServiceModel;
import com.example.anticshop.domain.viewModel.ItemsSummaryInfo;
import com.example.anticshop.domain.viewModel.ItemsViewModel;
import com.example.anticshop.repository.ItemRepository;
import com.example.anticshop.service.exeption.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository,
                           ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<ItemsSummaryInfo> getAllOrders() {
        return
                itemRepository
                        .findByCategory_Name(CategoryNameEnum.ORDERS)
                        .stream()
                        .map(itemEntity -> {
                            ItemsSummaryInfo orderSummeryInfo = modelMapper.map(itemEntity, ItemsSummaryInfo.class);
                            return orderSummeryInfo;
                        })
                        .collect(Collectors.toList());
    }

    @Override
    public List<ItemsSummaryInfo> getAllMedals() {
        return itemRepository
                .findByCategory_Name(CategoryNameEnum.MEDALS)
                .stream()
                .map(itemEntity -> {
                    ItemsSummaryInfo medalSummeryInfo = modelMapper.map(itemEntity, ItemsSummaryInfo.class);
                    return medalSummeryInfo;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemsSummaryInfo> getAllCoins() {
        return
                itemRepository
                        .findByCategory_Name(CategoryNameEnum.COINS)
                        .stream()
                        .map(itemEntity -> {
                            ItemsSummaryInfo coinsSummeryInfo = modelMapper.map(itemEntity, ItemsSummaryInfo.class);
                            return coinsSummeryInfo;
                        })
                        .collect(Collectors.toList());
    }

    @Override
    public void addNewItem(ItemAddServiceModel itemAddServiceModel) {
        ItemEntity item = modelMapper.map(itemAddServiceModel, ItemEntity.class);
        item.setPublished_on(now());
        item.setCategory(categoryService.findByCategoryNameEnum(itemAddServiceModel.getCategory()));
        itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemsViewModel> findAllItemsViewModel() {
        return itemRepository
                .findAll()
                .stream()
                .map(itemEntity -> {
                    ItemsViewModel itemsViewModel =
                            modelMapper.map(itemEntity, ItemsViewModel.class);

//                    if (itemEntity.getImageUrl().isEmpty()) {
//                        itemsViewModel.setImageUrl("/images/SvAleksandar1881.png");
//                    } else {
//                        itemsViewModel.setImageUrl(itemEntity.getImageUrl());
//                    }

                    itemsViewModel.setCategory(itemEntity.getCategory().getName());
                    return itemsViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemsViewModel findByIdItem(Long id) {
        return itemRepository.findById(id)
                .map(itemEntity -> modelMapper.map(itemEntity, ItemsViewModel.class))
                .orElseThrow(() -> new ObjectNotFoundException("Item with id" + id + "was not found"));
    }

    @Override
    @Transactional
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }


//    @Override
//      public ItemsViewModel  findById(Long id) {
//        ItemEntity itemEntity = this.itemRepository
//                .findById(id)
//                .orElse(null);
//
//        return this.modelMapper.map(itemEntity, ItemsViewModel.class);
//    }
//        ProductEntity productEntity = this.productRepository
//                .findById(productId)
//                .orElseThrow(() -> new NotFoundObjectException(productId, PRODUCT));
//
//        return this.modelMapper.map(productEntity, ProductViewDto.class);
//    }


//    public ItemsViewModel findById(Long id) {
//        return itemRepository.findById(id)
//                .map(itemEntity -> {
//                    ItemsViewModel itemsViewModel = modelMapper.map(itemEntity, ItemsViewModel.class);
//                    return itemsViewModel;
//                }).orElse(null);
//    }
//


}


//return itemRepository.findById(id)
//        .map(itemEntity -> {
//        ItemViewModel itemViewModel =
//        modelMapper.map(itemEntity, ItemViewModel.class);

//        itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", itemEntity.getGender(),
//        itemEntity.getCategory().getCategoryNameEnum().name()));
//        return itemViewModel;
//        }).orElse(null);


//       routeViewModel.setPicture(routeEntity.getPictures().stream().findFirst().get().getUrl());

//    @Override
//    public List<RouteViewModel> findAllRoutesViewModel() {
//        return routeRepository
//                .findAll()
//                .stream()
//                .map(routeEntity -> {
//                    RouteViewModel routeViewModel = modelMapper.map(routeEntity, RouteViewModel.class);
//
//                    if (routeEntity.getPictures().isEmpty()) {
//                        routeViewModel.setPicture("/imiges/pic1.jpg");
//                    } else {
//                        routeViewModel.setPicture(routeEntity.getPictures().stream().findFirst().get().getUrl());
//                    }
//
//                    return routeViewModel;
//                })
//                .collect(Collectors.toList());
//    }
//


//   @Override
//  public UUID createOffer(CreateOfferDTO createOfferDTO, UserDetails seller) {
//
//    OfferEntity newOffer = map(createOfferDTO);
//    ModelEntity modelEntity = modelRepository.findById(createOfferDTO.modelId()).orElseThrow(() ->
//        new IllegalArgumentException("Model with id " + createOfferDTO.modelId() + " not found!"));
//    UserEntity sellerEntity = userRepository.findByEmail(seller.getUsername()).orElseThrow(() ->
//        new IllegalArgumentException("User with email " + seller.getUsername() + " not found!"));
//
//
//    newOffer.setModel(modelEntity);
//    newOffer.setSeller(sellerEntity);
//
//    newOffer = offerRepository.save(newOffer);
//
//    return newOffer.getUuid();
//  }


//    public void addNewRoute(RouteAddServiceModel routeAddServiceModel) {
//
//        RouteEntity route = modelMapper.map(routeAddServiceModel, RouteEntity.class);
////        todo: current user
////        route.setAuthor(userService.findCurrentLoginUserEntity());
//        route.setCategories(routeAddServiceModel
//                .getCategories()
//                .stream()
//                .map(categoryNameEnum -> categoryService.findCathegoryByName(categoryNameEnum))
//                .collect(Collectors.toSet()));
//        routeRepository.save(route);
//    }

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