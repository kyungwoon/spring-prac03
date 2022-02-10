package com.example.springprac03.service;

import com.example.springprac03.dto.FoodRequestDto;
import com.example.springprac03.model.Food;
import com.example.springprac03.model.Restaurant;
import com.example.springprac03.repository.FoodRepository;
import com.example.springprac03.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void registerFood(@PathVariable Long restaurantId, List<FoodRequestDto> foodDto){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        for (FoodRequestDto food : foodDto)  {

            String name = food.getName();
            Food sameName = foodRepository.findByRestaurantAndName(restaurant, name);

            if (sameName != null) {
                throw new IllegalArgumentException("동일한 음식이 등록되어 있습니다.");
            }

            int price = food.getPrice();
            if (price < 100 || price > 1000000 || price % 100 != 0) {
                throw new IllegalArgumentException("100원 ~ 1,000,000원까지 입력 가능합니다.(100원 단위)");
            }

            Food foods = Food.builder()
                    .restaurant(restaurant)
                    .name(name)
                    .price(price)
                    .build();

            foodRepository.save(foods);
        }
    }

    // 음식 조회
    public List<Food> getFoods(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        return foodRepository.findAllByRestaurant(restaurant);
    }
}
