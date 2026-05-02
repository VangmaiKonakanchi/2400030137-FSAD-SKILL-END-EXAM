package com.klef.fsad.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.fsad.exam.model.Restaurant;
import com.klef.fsad.exam.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController 
{
    @Autowired
    private RestaurantService service;

    @PostMapping("/add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant)
    {
        if (restaurant.getRestaurantId() == null)
        {
            throw new RuntimeException("Restaurant ID must not be null!");
        }
        return service.addRestaurant(restaurant);
    }

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants()
    {
        return service.getAllRestaurants();
    } 
}
