package com.foodOrderingApp.app.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MenuItem extends BaseModel {
    private String itemName;
    private CuisineType cuisineType;
    private MealType mealType;
    private AvailabilityStatus availabilityStatus;
    private FoodType foodType;

    public MenuItem(String itemName, CuisineType cuisineType, MealType mealType, FoodType foodType) {
        this.itemName = itemName;
        this.cuisineType = cuisineType;
        this.mealType = mealType;
        this.foodType = foodType;
    }

    public MenuItem() {

    }
}
