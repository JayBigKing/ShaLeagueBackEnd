package com.example.shaleaguebackend.service;

import com.example.shaleaguebackend.model.domain.NowSeason;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shaleaguebackend.model.domain.Score;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
public interface NowSeasonService extends IService<NowSeason> {
    NowSeason getNowSeason();
}
