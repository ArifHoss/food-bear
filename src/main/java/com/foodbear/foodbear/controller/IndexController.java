/*

package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.pojos.FoodBearUser;
import com.foodbear.foodbear.entities.pojos.FoodItem;
import com.foodbear.foodbear.services.service.FoodBearUserService;
import com.foodbear.foodbear.services.service.FoodItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/index")
public class IndexController {

    private final FoodItemService foodItemService;

    //@Autowired
    public IndexController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }


    @GetMapping
    public String showFoodItems(Model model){
        //ModelAndView mav = new ModelAndView("index");

        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        //mav.addObject("fooditems", foodItems);

        model.addAttribute("fooditems", foodItems);

        return "index";
    }
}

*/
