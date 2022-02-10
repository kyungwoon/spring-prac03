package com.example.springprac03.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //PK

    @ManyToOne
    @JoinColumn(name="restaurant_id", nullable = false)
    private Restaurant restaurant;  //FK


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Builder
    public Food(String name, Restaurant restaurant, int price){
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
    }
}
