package com.foodOrderingApp.app.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Delivery extends BaseModel {
    private Long userId;
    private Long deliveryBoyId;
    private Long orderId;
    private Date deliveryItem;
}
