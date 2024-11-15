package kz.restaurantservice.controller;

import kz.restaurantservice.entity.RestaurantEntity;
import kz.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    // Get all restaurants
    @GetMapping
    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // Get a restaurant by id
    @GetMapping("/{id}")
    public Optional<RestaurantEntity> getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    // Create or update a restaurant
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantEntity createRestaurant(@RequestBody RestaurantEntity restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }

    // Delete a restaurant by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }
}
