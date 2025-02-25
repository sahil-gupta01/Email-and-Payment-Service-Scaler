package com.foodOrderingApp.app.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Order extends BaseModel {
    private OrderStatus orderStatus;
    private Long userId;
    private Long restaurantId;
    private List<MenuItem> menuItemList;

    public Order(Long userId, Long restaurantId, List<MenuItem> menuItemList) {
        this.orderStatus = OrderStatus.PENDING;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.menuItemList = menuItemList;
    }

}
