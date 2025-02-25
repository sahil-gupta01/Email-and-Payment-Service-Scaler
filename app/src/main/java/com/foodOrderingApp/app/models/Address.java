package com.foodOrderingApp.app.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address extends BaseModel {
    private String houseNumber;
    private String zipCode;
    private String street;
    private String city;
    private String area;
    private String state;
    private String country;
    //private Location location;


}
