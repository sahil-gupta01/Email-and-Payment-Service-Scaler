package com.foodOrderingApp.app.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant extends BaseModel{
    private String name;
    private Address address;
    private RestaurantStatus restaurantStatus;
    private RestaurantType restaurantType;

}
