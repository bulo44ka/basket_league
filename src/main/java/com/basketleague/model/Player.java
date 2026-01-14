package com.basketleague.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private int id;
    private String name;
    private String position;
    private int teamId;
    private Integer height;
    private Integer weight;
    private String photo;
}
