package kz.restaurantservice.repository;

import kz.restaurantservice.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    // Custom queries can be added here if necessary
}
