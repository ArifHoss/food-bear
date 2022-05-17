package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.pojos.Promotion;

import java.util.List;
import java.util.Map;

public interface PromotionService {
    List<Promotion> getAllPromotions();

    Promotion create(Promotion promotion);

    Promotion getById(Long id);

    Promotion update(Long promotionId, Map<Object, Object> fields);

    String delete(Long id);
}
