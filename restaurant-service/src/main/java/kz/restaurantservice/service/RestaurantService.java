package kz.restaurantservice.service;

import kz.restaurantservice.entity.RestaurantEntity;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    // Get all restaurants
    List<RestaurantEntity> getAllRestaurants();

    // Get a restaurant by id
    Optional<RestaurantEntity> getRestaurantById(Long id);

    // Create or update a restaurant
    RestaurantEntity saveRestaurant(RestaurantEntity restaurant);

    // Delete a restaurant by id
    void deleteRestaurant(Long id);
}
