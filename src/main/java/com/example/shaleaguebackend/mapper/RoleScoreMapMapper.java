package com.example.shaleaguebackend.mapper;

import com.example.shaleaguebackend.model.domain.RoleScoreMap;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
public interface RoleScoreMapMapper extends BaseMapper<RoleScoreMap> {

    RoleScoreMap getRoleScoreMap();
}
