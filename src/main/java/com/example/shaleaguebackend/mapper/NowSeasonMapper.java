package com.example.shaleaguebackend.mapper;

import com.example.shaleaguebackend.model.domain.NowSeason;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shaleaguebackend.model.domain.Score;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
public interface NowSeasonMapper extends BaseMapper<NowSeason> {

    NowSeason getNowSeason();
}
