package com.foodbear.foodbear.service;

import com.foodbear.foodbear.entities.FoodItem;
import com.foodbear.foodbear.entities.FoodOrder;
import com.foodbear.foodbear.entities.Promotion;
import com.foodbear.foodbear.exception.ResourceNotFoundException;
import com.foodbear.foodbear.repo.FoodItemDaoJpa;
import com.foodbear.foodbear.repo.FoodOrderDaoJpa;
import com.foodbear.foodbear.repo.PromotionDaoJpa;
import com.foodbear.foodbear.sender.Sender;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Service("orderService")
public class FoodOrderService {

    private FoodOrderDaoJpa orderDaoJpa;
    private FoodItemDaoJpa foodItemDaoJpa;
    private PromotionDaoJpa promotionDaoJpa;



    public List<FoodOrder> getAllOrder() {
        return orderDaoJpa.findAll();
    }

    public FoodOrder createOrder(FoodOrder foodBearOrder) {
        Sender.sendMessage(foodBearOrder.getTotalPrice());
        return orderDaoJpa.save(foodBearOrder);
    }

    public void deleteOrder(Long id) {
        orderDaoJpa.deleteById(id);
    }

    public void updateOrder(Long id, FoodOrder foodBearOrder) {
        FoodOrder foundOrder = orderDaoJpa.findById(id).orElseThrow(()->new ResourceNotFoundException("INVALID_ORDER_ID"));

        orderDaoJpa.save(foundOrder);
    }

    public FoodOrder createAOrderItemAndPromotion(FoodOrder order, Long foodItemId, Long promotionId) {


        FoodItem foodItem = foodItemDaoJpa.findById(foodItemId).orElseThrow(() -> new ResourceNotFoundException("INCORRECT_FOOD_ITEM_ID"));
        Promotion promotion = promotionDaoJpa.findById(promotionId).orElseThrow(() -> new ResourceNotFoundException("INCORRECT_PROMOTION_ID"));
        order.setOrderItems((Set<FoodItem>) foodItem);
        order.setPromotion(promotion);

        return orderDaoJpa.save(order);
    }
}
