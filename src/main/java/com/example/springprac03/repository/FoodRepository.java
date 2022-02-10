package com.example.springprac03.repository;

import com.example.springprac03.model.Food;
import com.example.springprac03.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByRestaurant(Restaurant restaurant);
    Food findByRestaurantAndName(Restaurant restaurant, String name);
    Food findByRestaurantAndId(Restaurant restaurant, Long id);

}
