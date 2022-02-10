package com.example.springprac03.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodRequestDto {
    private Long id;
    private Long restId;
    private String name;
    private int price;

//    @Builder
//    public FoodRequestDto(Long restId, String name, int price){
//        this.restId = restId;
//        this.name = name;
//        this.price = price;
//    }

}
