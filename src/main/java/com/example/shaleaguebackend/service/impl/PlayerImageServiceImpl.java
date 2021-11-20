package com.example.shaleaguebackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shaleaguebackend.model.domain.PlayerImage;
import com.example.shaleaguebackend.mapper.PlayerImageMapper;
import com.example.shaleaguebackend.service.PlayerImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jay
 * @since 2021-11-18
 */
@Service
public class PlayerImageServiceImpl extends ServiceImpl<PlayerImageMapper, PlayerImage> implements PlayerImageService {

    @Override
    public PlayerImage getByPid(Long id) {
        QueryWrapper<PlayerImage> wrapper = new QueryWrapper<>();
        wrapper.eq("Pid",id);
        PlayerImage playerImage  = this.getOne(wrapper);
        return playerImage;
    }
}
