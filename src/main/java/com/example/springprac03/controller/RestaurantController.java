package com.example.springprac03.controller;

import com.example.springprac03.dto.RestaurantRequestDto;
import com.example.springprac03.model.Restaurant;
import com.example.springprac03.repository.RestaurantRepository;
import com.example.springprac03.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
//    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        return restaurantService.registerRestaurant(restaurantRequestDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantService.readRestaurant();
    }
}
