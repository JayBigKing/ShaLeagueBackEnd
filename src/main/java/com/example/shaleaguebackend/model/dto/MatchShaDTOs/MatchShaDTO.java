package com.example.shaleaguebackend.model.dto.MatchShaDTOs;

import com.example.shaleaguebackend.model.dto.RoleDTOs.RoleFrontDTO;
import lombok.Data;

@Data
public class MatchShaDTO {
    private String winner;
    private RoleFrontDTO[] roles;

}
