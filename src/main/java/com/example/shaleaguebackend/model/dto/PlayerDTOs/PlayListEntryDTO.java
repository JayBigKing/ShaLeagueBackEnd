package com.example.shaleaguebackend.model.dto.PlayerDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class PlayListEntryDTO {
    protected String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long Pid;
    protected int score;
    protected double win;
    protected int totalWin ;
    protected int totalLose ;
    protected int total;
}
