package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.FoodOrder;
import com.foodbear.foodbear.service.FoodOrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/order")
public class FoodOrderController {

    private FoodOrderService orderService;

    @GetMapping
    public List<FoodOrder> getAllOrders(){
        return orderService.getAllOrder();
    }

    @GetMapping("{orderId}")
    public FoodOrder getOrderById(@PathVariable("orderId") Long orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public FoodOrder createOrder(@RequestBody FoodOrder foodBearOrder){
        return orderService.createOrder(foodBearOrder);
    }

    @PostMapping("fooditem/{foodItemId}/promotion/{promotionId}")
    public FoodOrder createAOrderWithItemAndPromotion(@RequestBody FoodOrder order,
                                                      @PathVariable("foodItemId") Long foodItemId,
                                                      @PathVariable("promotionId") Long promotionId){
        return orderService.createAOrderItemAndPromotion(order,foodItemId,promotionId);

    }


    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id")Long id){
        orderService.deleteOrder(id);
        return "ORDER HAS BEEN DELETED";
    }

    @PatchMapping("/{id}")
    public FoodOrder updateOrder(@PathVariable("id")Long id, @RequestBody FoodOrder foodBearOrder){
        return orderService.updateOrder(id, foodBearOrder);
    }
}
