package com.basketleague.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopItem {
    private int id;
    private String name;
    private String image;
    private int price;
}
