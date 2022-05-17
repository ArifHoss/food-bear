package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.dto.PromotionDto;
import com.foodbear.foodbear.entities.pojos.Promotion;
import com.foodbear.foodbear.services.service.PromotionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

    @GetMapping
    public List<PromotionDto> getAllPromotions(){
        return promotionService.getAllPromotions().stream()
                .map(promotion -> modelMapper.map(promotion, PromotionDto.class)).toList();
    }

    @GetMapping("/{id}")
    public PromotionDto getById(@PathVariable Long id){
        Promotion foundPromotion = promotionService.getById(id);
        return modelMapper.map(foundPromotion, PromotionDto.class);
    }

    @PostMapping
    public PromotionDto create(@RequestBody Promotion promotion){
        Promotion newPromotion = promotionService.create(promotion);
        return modelMapper.map(newPromotion, PromotionDto.class);
    }
    @PatchMapping("/{id}")
    public PromotionDto update(@PathVariable Long id, @RequestBody Map<Object, Object> fields){
        Promotion updatedPromotion = promotionService.update(id, fields);
        return modelMapper.map(updatedPromotion, PromotionDto.class);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return promotionService.delete(id);
    }



}
