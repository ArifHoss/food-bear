package com.foodbear.foodbear.services.impl;

import com.foodbear.foodbear.entities.FoodItem;
import com.foodbear.foodbear.entities.FoodOrder;
import com.foodbear.foodbear.entities.Promotion;
import com.foodbear.foodbear.exception.ResourceNotFoundException;
import com.foodbear.foodbear.repo.FoodItemDaoJpa;
import com.foodbear.foodbear.repo.FoodOrderDaoJpa;
import com.foodbear.foodbear.repo.PromotionDaoJpa;
import com.foodbear.foodbear.sender.Sender;
import com.foodbear.foodbear.services.service.FoodOrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Service("orderService")
public class FoodOrderServiceImpl implements FoodOrderService {

    private FoodOrderDaoJpa orderDaoJpa;
    private FoodItemDaoJpa foodItemDaoJpa;
    private PromotionDaoJpa promotionDaoJpa;



    @Override
    public List<FoodOrder> getAllOrder() {
        return orderDaoJpa.findAll();
    }

    @Override
    public FoodOrder createOrder(FoodOrder foodBearOrder) {
        Sender.sendMessage(foodBearOrder.getTotalPrice());
        return orderDaoJpa.save(foodBearOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        FoodOrder order = findOrderById(id);
        orderDaoJpa.delete(order);
    }

    @Override
    public FoodOrder updateOrder(Long id, FoodOrder order) {
        FoodOrder foundOrder = findOrderById(id);
        Long totalPrice = order.getTotalPrice();

        if (totalPrice != null){
            foundOrder.setTotalPrice(totalPrice);
        }
       return orderDaoJpa.save(foundOrder);
    }

    @Override
    public FoodOrder createAOrderItemAndPromotion(FoodOrder order, Long foodItemId, Long promotionId) {


        FoodItem foodItem = foodItemDaoJpa.findById(foodItemId).orElseThrow(() -> new ResourceNotFoundException("INCORRECT_FOOD_ITEM_ID"));
        Promotion promotion = promotionDaoJpa.findById(promotionId).orElseThrow(() -> new ResourceNotFoundException("INCORRECT_PROMOTION_ID"));
        order.setOrderItems((Set<FoodItem>) foodItem);
        order.setPromotion(promotion);

        return orderDaoJpa.save(order);
    }

    @Override
    public FoodOrder getOrderById(Long orderId) {
        return findOrderById(orderId);
    }

    @Override
    public FoodOrder addItemToOrder(Long orderId, Long itemId) {
        FoodOrder order = findOrderById(orderId);
        FoodItem item = foodItemDaoJpa.findById(itemId).orElseThrow(() ->
                new ResourceNotFoundException("INVALID_ITEM_ID"));
        order.getOrderItems().add(item);

        Set<FoodItem> orderItem = order.getOrderItems();

//        Long tot = order.getTotalPrice();
//
//       order.setTotalPrice(totalPriceCaulculator(orderItem, tot));
        return orderDaoJpa.save(order);
    }

//    private long totalPriceCaulculator(Set<FoodItem> orderItem, Long tot) {
//
//
//        for (FoodItem i: orderItem) {
//           Long t = i.getPrice();
//           tot += t;
//        }
//        return tot;
//    }

    @Override
    public FoodOrder addPromotionToOrder(Long orderId, Long promotionId) {

        FoodOrder order = findOrderById(orderId);
        Promotion promotion = promotionDaoJpa.findById(promotionId).orElseThrow(()->
                new ResourceNotFoundException("INVALID_PROMOTION_ID"));
        order.setPromotion(promotion);
        return orderDaoJpa.save(order);
    }

    private FoodOrder findOrderById(Long orderId) {
        return orderDaoJpa.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("INVALID_ORDER_ID"));
    }
}
