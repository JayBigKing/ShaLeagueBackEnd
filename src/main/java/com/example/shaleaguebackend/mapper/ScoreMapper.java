package com.example.shaleaguebackend.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shaleaguebackend.model.domain.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayListEntryDTO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
public interface ScoreMapper extends BaseMapper<Score> {

    Page<PlayListEntryDTO> listPage(@Param("page")Page<PlayListEntryDTO>page);
}
