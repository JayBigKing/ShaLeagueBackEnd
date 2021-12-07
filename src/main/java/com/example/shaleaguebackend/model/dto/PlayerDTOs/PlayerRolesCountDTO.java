package com.example.shaleaguebackend.model.dto.PlayerDTOs;

import lombok.Data;

@Data
public class PlayerRolesCountDTO {
    private String name;
    private Long Pid;
    private int totalRoleWin ;
    private int totalRoleLose ;
    private int total;
}
