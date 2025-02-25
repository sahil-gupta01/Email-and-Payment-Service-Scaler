package com.foodOrderingApp.app.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Bill extends BaseModel {
    private double totalCost;
    private double discount;
    private double tax;
    private double netAmount;
}
