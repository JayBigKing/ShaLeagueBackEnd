package com.example.shaleaguebackend.model.dto.PlayerDTOs;

import lombok.Data;

@Data
public class PlayerWInLoseCountDTO {
    private String name;
    private Long Pid;
    private int totalWin ;
    private int totalLose ;
    private int total;
}
