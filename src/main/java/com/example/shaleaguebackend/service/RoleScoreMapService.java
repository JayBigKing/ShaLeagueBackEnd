package com.example.shaleaguebackend.service;

import com.example.shaleaguebackend.model.domain.RoleScoreMap;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
public interface RoleScoreMapService extends IService<RoleScoreMap> {
    RoleScoreMap getRoleScoreMap();
}
