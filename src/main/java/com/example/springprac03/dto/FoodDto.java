package com.example.springprac03.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDto {
    private Long id;
    private Long restaurantId;
    private String name;
    private int price;

    @Builder
    public FoodDto(Long restaurantId, String name, int price){
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
    }
}
