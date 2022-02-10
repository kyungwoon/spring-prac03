package com.example.springprac03.dto;

import lombok.Getter;

import java.util.List;

//주문 요청
@Getter
public class OrderRequestDto {
    private Long restaurantId;
    private List<FoodOrderRequestDto> foods; // food id, quantity

    public OrderRequestDto(Long restaurantId, List<FoodOrderRequestDto> foods) {
        this.restaurantId = restaurantId;
        this.foods = foods;
    }
}
