package com.example.shaleaguebackend.model.dto.PlayerDTOs;

import lombok.Data;

@Data
public class PlayListEntryWithImgDTO extends PlayListEntryDTO {
    private String imgSrc;

    public void setItselt(PlayListEntryDTO playListEntryDTO , String theImgSrc){
        imgSrc = theImgSrc;
        this.name = playListEntryDTO.name;
        this.Pid = playListEntryDTO.Pid;
        this.score = playListEntryDTO.score;
        this.win = playListEntryDTO.win;
        this.totalWin = playListEntryDTO.totalWin;
        this.totalLose = playListEntryDTO.totalLose;
        this.total = playListEntryDTO.total;
    }
}
