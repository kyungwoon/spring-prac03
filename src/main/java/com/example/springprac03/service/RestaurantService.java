package com.example.springprac03.service;

import com.example.springprac03.dto.RestaurantDto;
import com.example.springprac03.model.Restaurant;
import com.example.springprac03.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    //식당 등록
    public Restaurant registerRestaurant(RestaurantDto requestDto) {
        String name = requestDto.getName();
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();


        if (minOrderPrice < 1000 || minOrderPrice > 100000 || minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("1,000원 ~ 100,000원 주문이 가능합니다.(100원 단위 주문 가능)");
        }

        if (deliveryFee < 0 || deliveryFee > 10000 || deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("0원 ~ 10,000원 배달비 입력이 가능합니다.(500원 단위)");
        }


        Restaurant restaurant = Restaurant.builder()
                .name(name)
                .deliveryFee(deliveryFee)
                .minOrderPrice(minOrderPrice)
                .build();
        return restaurantRepository.save(restaurant);
    }
    //식당 조회
    @Transactional
    public List<Restaurant> readRestaurant (){
        return restaurantRepository.findAll();
    }
}


