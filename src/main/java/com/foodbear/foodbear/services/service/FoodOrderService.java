package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.FoodOrder;

import java.util.List;

public interface FoodOrderService {
    List<FoodOrder> getAllOrder();

    FoodOrder createOrder(FoodOrder foodBearOrder);

    void deleteOrder(Long id);

    FoodOrder updateOrder(Long id, FoodOrder order);

    FoodOrder createAOrderItemAndPromotion(FoodOrder order, Long foodItemId, Long promotionId);

    FoodOrder getOrderById(Long orderId);

    FoodOrder addItemToOrder(Long orderId, Long itemId);

    FoodOrder addPromotionToOrder(Long orderId, Long promotionId);
}
