package com.example.springprac03.controller;

import com.example.springprac03.dto.FoodRequestDto;
import com.example.springprac03.model.Food;
import com.example.springprac03.repository.FoodRepository;
import com.example.springprac03.repository.RestaurantRepository;
import com.example.springprac03.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")    //음식 등록
    public void registerRestaurant(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> food) {
        foodService.registerFood(restaurantId, food);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoods(@PathVariable Long restaurantId){

        return foodService.getFoods(restaurantId);
    }
}
