package com.example.shaleaguebackend.mapper;

import com.example.shaleaguebackend.model.domain.PlayerImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jay
 * @since 2021-11-18
 */
public interface PlayerImageMapper extends BaseMapper<PlayerImage> {

    void updateByPid(@Param("pid")Long pid, @Param("imgUrl")String imgUrl);
}
