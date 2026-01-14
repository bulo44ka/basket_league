package com.basketleague.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private int id;
    private String name;
    private String city;
    private String logo;
}
