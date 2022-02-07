package com.example.springprac03.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class  Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //식당명
    @Column(nullable = false)
    private String name;

    //최소 주문 가격(1000~100,000원 100원 단위)
    @Column(nullable = false)
    private int minOrderPrice;

    //배달비(0~10,000원 500원 단위)
    @Column(nullable = false)
    private int deliveryFee;

    @Builder
    public Restaurant(String name, int minOrderPrice, int deliveryFee) {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}




