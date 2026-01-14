package com.basketleague.shop;

import com.basketleague.model.ShopItem;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private ShopItem item;
    private int quantity;
}
