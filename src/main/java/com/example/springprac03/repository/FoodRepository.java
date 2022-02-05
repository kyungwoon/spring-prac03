package com.example.springprac03.repository;

import com.example.springprac03.model.Food;
import com.example.springprac03.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByRestaurantAndName(Restaurant restaurant, String name);
    List<Food> findAllByRestaurant(Restaurant restaurant);
}
