package com.example.shaleaguebackend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shaleaguebackend.model.domain.Player;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayListEntryDTO;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerRolesCountDTO;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerWInLoseCountDTO;
import com.example.shaleaguebackend.model.enums.RolesEnum;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
public interface PlayerService extends IService<Player> {


    PlayerWInLoseCountDTO getWinLoseDetailById(Long id);


    PlayerRolesCountDTO getRolesDetailById(Long id, RolesEnum theLord);

    Page<Player> listPageByName(String name, int currentPage, int pageSize);
}
