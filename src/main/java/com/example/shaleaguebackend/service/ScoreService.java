package com.example.shaleaguebackend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shaleaguebackend.model.domain.RoleScoreMap;
import com.example.shaleaguebackend.model.domain.Score;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayListEntryDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
public interface ScoreService extends IService<Score> {

    Page<PlayListEntryDTO> listPage(int currentPage, int pageSize);
    Score getByPid(Long pid);
    void updateScoreAfterMatchSha(Long Sid, Long Pid , int theRole , int result , RoleScoreMap roleScoreMap , int givenScore);
}
