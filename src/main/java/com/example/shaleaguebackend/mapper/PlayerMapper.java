package com.example.shaleaguebackend.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shaleaguebackend.model.domain.Player;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayListEntryDTO;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerRolesCountDTO;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerWInLoseCountDTO;
import com.example.shaleaguebackend.model.enums.RolesEnum;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */

public interface PlayerMapper extends BaseMapper<Player> {

    PlayerWInLoseCountDTO getWinLoseDetailById(Long id);

    PlayerRolesCountDTO getRoleDetailById(Long id, int theLord);

    Page<Player> listPageByName(String name, @Param("page")Page<Player>page);
}
