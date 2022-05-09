package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.Promotion;
import com.foodbear.foodbear.service.PromotionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/promotion")
public class PromotionController {

    private PromotionService promotionService;

    @GetMapping
    public List<Promotion> getAllPromotions(){
        return promotionService.getAllPromotions();
    }

    @GetMapping("/{id}")
    public Promotion getById(@PathVariable Long id){
        return promotionService.getById(id);
    }

    @PostMapping
    public Promotion create(@RequestBody Promotion promotion){
        return promotionService.create(promotion);
    }
    @PatchMapping("/{id}")
    public Promotion update(@PathVariable Long id, @RequestBody Map<Object, Object> fields){
        return promotionService.update(id, fields);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return promotionService.delete(id);
    }



}
