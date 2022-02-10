package com.example.springprac03.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int deliveryFee;

    @Column
    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public Orders(int deliveryFee, int totalPrice, Restaurant restaurant) {
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
        this.restaurant = restaurant;
    }
}
