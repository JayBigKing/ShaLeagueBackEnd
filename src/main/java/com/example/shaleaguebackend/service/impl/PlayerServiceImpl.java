package com.example.shaleaguebackend.service.impl;

import com.example.shaleaguebackend.model.domain.Player;
import com.example.shaleaguebackend.mapper.PlayerMapper;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerRolesCountDTO;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerWInLoseCountDTO;
import com.example.shaleaguebackend.model.enums.RolesEnum;
import com.example.shaleaguebackend.service.PlayerService;
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
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements PlayerService {
    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public PlayerWInLoseCountDTO getWinLoseDetailById(Long id) {
        return playerMapper.getWinLoseDetailById(id);
    }

    @Override
    public PlayerRolesCountDTO getRolesDetailById(Long id, RolesEnum theLord) {
        return playerMapper.getRoleDetailById(id,theLord.ordinal());
    }

}
