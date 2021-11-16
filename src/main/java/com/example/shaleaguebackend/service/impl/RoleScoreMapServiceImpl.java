package com.example.shaleaguebackend.service.impl;

import com.example.shaleaguebackend.model.domain.RoleScoreMap;
import com.example.shaleaguebackend.mapper.RoleScoreMapMapper;
import com.example.shaleaguebackend.service.RoleScoreMapService;
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
public class RoleScoreMapServiceImpl extends ServiceImpl<RoleScoreMapMapper, RoleScoreMap> implements RoleScoreMapService {

    @Autowired
    RoleScoreMapMapper roleScoreMapMapper;
    @Override
    public RoleScoreMap getRoleScoreMap() {
        return roleScoreMapMapper.getRoleScoreMap();
    }
}
