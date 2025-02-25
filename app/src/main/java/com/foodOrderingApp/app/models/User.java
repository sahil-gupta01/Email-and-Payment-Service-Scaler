package com.foodOrderingApp.app.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User extends BaseModel {
    private String name;
    private String email;
    private int age;
    private Gender gender;
    private String phoneNum;
    private Address address;
}
