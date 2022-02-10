package com.example.springprac03.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {     //주문 조회
    private String restaurantName;
    private List<FoodOrderDto> foods;

    @Builder
    public OrderDto(String restaurantName, List<FoodOrderDto> foods) {
        this.restaurantName = restaurantName;
        this.foods = foods;
    }
}
