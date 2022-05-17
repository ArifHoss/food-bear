package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.dto.FoodOrderDto;
import com.foodbear.foodbear.entities.pojos.FoodOrder;
import com.foodbear.foodbear.services.service.FoodOrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/order")
public class FoodOrderController {

    private FoodOrderService orderService;
    private ModelMapper modelMapper;

    @GetMapping
    public List<FoodOrderDto> getAllOrders(){
        return orderService.getAllOrder().stream()
                .map(order -> modelMapper.map(order, FoodOrderDto.class)).toList();
    }

    @GetMapping("{orderId}")
    public FoodOrderDto getOrderById(@PathVariable("orderId") Long orderId){
        FoodOrder foundOrder = orderService.getOrderById(orderId);
        return modelMapper.map(foundOrder, FoodOrderDto.class);
    }

    @PostMapping
    public FoodOrderDto createOrder(@RequestBody FoodOrder foodBearOrder){
        FoodOrder newOrder = orderService.createOrder(foodBearOrder);
        return modelMapper.map(newOrder, FoodOrderDto.class);

    }

    @PostMapping("fooditem/{foodItemId}/promotion/{promotionId}")
    public FoodOrderDto createAOrderWithItemAndPromotion(@RequestBody FoodOrder order,
                                                      @PathVariable("foodItemId") Long foodItemId,
                                                      @PathVariable("promotionId") Long promotionId){
        FoodOrder newOrderwithPromotion = orderService.createAOrderItemAndPromotion(order, foodItemId, promotionId);
        return modelMapper.map(newOrderwithPromotion, FoodOrderDto.class);
    }



    @PutMapping("{orderId}/item/{itemId}")
    public FoodOrderDto addItemToOrder(@PathVariable("orderId") Long orderId,
                                    @PathVariable("itemId") Long itemId){
        FoodOrder newItemOnOrder = orderService.addItemToOrder(orderId, itemId);
        return modelMapper.map(newItemOnOrder, FoodOrderDto.class);
    }

    @PutMapping("{orderId}/promotion/{promotionId}")
    public FoodOrderDto addPromotionToOrder(@PathVariable("orderId") Long orderId,
                                    @PathVariable("promotionId") Long promotionId){
        FoodOrder newPromotionOnOrder = orderService.addPromotionToOrder(orderId, promotionId);
        return modelMapper.map(newPromotionOnOrder, FoodOrderDto.class);
    }


    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id")Long id){
        orderService.deleteOrder(id);
        return "ORDER HAS BEEN DELETED";
    }

    @PatchMapping("/{id}")
    public FoodOrderDto updateOrder(@PathVariable("id")Long id, @RequestBody FoodOrder foodBearOrder){
        FoodOrder updatedOrder = orderService.updateOrder(id, foodBearOrder);
        return modelMapper.map(updatedOrder, FoodOrderDto.class);
    }
}
