package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.pojos.FoodOrder;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface FoodOrderService {
    List<FoodOrder> getAllOrder();

    @Secured("ROLE_CUSTOMER")
    FoodOrder createOrder(FoodOrder foodBearOrder);

    @Secured("ROLE_CUSTOMER")
    void deleteOrder(Long id);

    @Secured("ROLE_CUSTOMER")
    FoodOrder updateOrder(Long id, FoodOrder order);

    @Secured("ROLE_CUSTOMER")
    FoodOrder createAOrderItemAndPromotion(FoodOrder order, Long foodItemId, Long promotionId);

    @Secured("ROLE_CUSTOMER")
    FoodOrder getOrderById(Long orderId);

    @Secured("ROLE_CUSTOMER")
    FoodOrder addItemToOrder(Long orderId, Long itemId);

    FoodOrder addPromotionToOrder(Long orderId, Long promotionId);
}
