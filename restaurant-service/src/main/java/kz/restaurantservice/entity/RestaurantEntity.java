package kz.restaurantservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="restaurants")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;

}
