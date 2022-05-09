package com.foodbear.foodbear.service;

import com.foodbear.foodbear.entities.Promotion;
import com.foodbear.foodbear.exception.ResourceNotFoundException;
import com.foodbear.foodbear.repo.PromotionDaoJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Service("promotionService")
public class PromotionService {

    private PromotionDaoJpa promotionDaoJpa;


    public List<Promotion> getAllPromotions() {
        return promotionDaoJpa.findAll();
    }

    public Promotion create(Promotion promotion) {
        return promotionDaoJpa.save(promotion);
    }

    public Promotion getById(Long id) {
        return findPromotionById(id);
    }


    public Promotion update(Long promotionId, Map<Object, Object> fields) {

        Promotion promotion = findPromotionById(promotionId);

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Promotion.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, promotion, value);

        });
        return promotionDaoJpa.save(promotion);
    }

    public String delete(Long id) {

        Promotion promotion = findPromotionById(id);
        promotionDaoJpa.delete(promotion);

        return "PROMOTION_HAS_BEEN_DELETED";
    }


    private Promotion findPromotionById(Long id) {
        return promotionDaoJpa.findById(id).orElseThrow(() -> new ResourceNotFoundException("INVALID_PROMOTION_ID"));
    }
}
