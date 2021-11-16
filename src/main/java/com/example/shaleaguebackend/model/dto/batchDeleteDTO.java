package com.example.shaleaguebackend.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class batchDeleteDTO {
    private List<Long> ids;
}
