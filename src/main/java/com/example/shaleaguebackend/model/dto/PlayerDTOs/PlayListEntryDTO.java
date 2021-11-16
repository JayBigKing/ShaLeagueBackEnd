package com.example.shaleaguebackend.model.dto.PlayerDTOs;

import lombok.Data;

@Data
public class PlayListEntryDTO {
    private String name;
    private Long Pid;
    private int score;
    private int totalWin ;
    private int totalLose ;
    private int total;
}
