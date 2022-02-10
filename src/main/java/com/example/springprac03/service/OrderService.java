package com.example.springprac03.service;

import com.example.springprac03.dto.FoodOrderDto;
import com.example.springprac03.dto.FoodOrderRequestDto;
import com.example.springprac03.dto.OrderDto;
import com.example.springprac03.dto.OrderRequestDto;
import com.example.springprac03.model.Food;
import com.example.springprac03.model.OrderDetails;
import com.example.springprac03.model.Restaurant;
import com.example.springprac03.repository.FoodRepository;
import com.example.springprac03.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public OrderDto createOrder(OrderRequestDto orderRequestDto) { //식당Id, 음식id, quantity 주입
        //식당 id 가져와
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElse(null);
        // 식당의 음식 다 찾아
        List<Food> foods = foodRepository.findAllByRestaurant(restaurant);
//        food, quantity, price repository 저장하기 위해
        List<OrderDetails> orderDetails = new ArrayList<>();
        List<FoodOrderDto> foodOrderDto = new ArrayList<>(); // 반환
        int totalPrice = 0;
        for (FoodOrderRequestDto foodOrderRequestDto : orderRequestDto.getFoods()) {
            for (Food food : foods) {
                if (food.getId().equals(foodOrderRequestDto.getId())) {
                    if (foodOrderRequestDto.getQuantity() < 1 || foodOrderRequestDto.getQuantity() > 100) {
                        throw new IllegalArgumentException("수량을 다시 입력해주세요 (1~100까지 입력 가능");
                    }
                    int quantity = foodOrderRequestDto.getQuantity();
                    int price = food.getPrice() * quantity;

                    orderDetails.add(new OrderDetails(food.getName(), quantity, price));
                    totalPrice += price;

                    foodOrderDto.add(new FoodOrderDto(food.getName(), quantity, price));
                }
            }
        }
        OrderDto orderDto = OrderDto.builder()
                .restaurantName(restaurant.getName())
                .foods(foodOrderDto)
                .build();
        return orderDto;
    }
}
