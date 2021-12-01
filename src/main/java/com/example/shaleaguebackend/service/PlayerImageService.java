package com.example.shaleaguebackend.service;

import com.example.shaleaguebackend.model.domain.PlayerImage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jay
 * @since 2021-11-18
 */
public interface PlayerImageService extends IService<PlayerImage> {

    PlayerImage getByPid(Long id);

    boolean updateByPid(PlayerImage playerImage);
}
