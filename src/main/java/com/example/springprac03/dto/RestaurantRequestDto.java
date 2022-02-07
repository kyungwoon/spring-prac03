package com.example.springprac03.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantRequestDto {
    private Long id;
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
