package com.example.springprac03.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderDto {
    private String name;
    private int quantity;
    private int price;

    @Builder
    public FoodOrderDto(String name, int quantity, int price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}