package com.example.shaleaguebackend.service.impl;

import com.example.shaleaguebackend.model.domain.NowSeason;
import com.example.shaleaguebackend.mapper.NowSeasonMapper;
import com.example.shaleaguebackend.model.domain.Score;
import com.example.shaleaguebackend.service.NowSeasonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
@Service
public class NowSeasonServiceImpl extends ServiceImpl<NowSeasonMapper, NowSeason> implements NowSeasonService {
    @Autowired
    NowSeasonMapper nowSeasonMapper;

    @Override
    public NowSeason getNowSeason() {
        return nowSeasonMapper.getNowSeason();
    }
}
