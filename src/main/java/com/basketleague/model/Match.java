package com.basketleague.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    private int id;

    private int teamHomeId;
    private int teamAwayId;

    private LocalDateTime matchDate;

    private String status;   // PLANNED, FINISHED

    private Integer homeScore;
    private Integer awayScore;
}
