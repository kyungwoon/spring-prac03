package com.example.springprac03.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodRequestDto {
    private Long id;
    private String name;
    private int price;

}
