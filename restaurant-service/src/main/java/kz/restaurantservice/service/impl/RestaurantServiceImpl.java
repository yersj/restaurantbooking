package kz.restaurantservice.service.impl;

import kz.restaurantservice.entity.RestaurantEntity;
import kz.restaurantservice.repository.RestaurantRepository;
import kz.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<RestaurantEntity> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public RestaurantEntity saveRestaurant(RestaurantEntity restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
