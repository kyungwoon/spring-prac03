package com.example.springprac03.service;

import com.example.springprac03.dto.RestaurantRequestDto;
import com.example.springprac03.model.Restaurant;
import com.example.springprac03.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    //식당 등록
    @Transactional
    public Restaurant registerRestaurant(RestaurantRequestDto requestDto) {
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();


        if (minOrderPrice < 1000 || minOrderPrice > 100000 || minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("1,000원 ~ 100,000원 주문이 가능합니다.(100원 단위 주문 가능)");
        }

        if (deliveryFee < 0 || deliveryFee > 10000 || deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("0원 ~ 10,000원 배달비 입력이 가능합니다.(500원 단위)");
        }


        Restaurant restaurant = new Restaurant(requestDto);
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }
}


