package com.example.shaleaguebackend.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shaleaguebackend.mapper.PlayerMapper;
import com.example.shaleaguebackend.model.domain.Score;
import com.example.shaleaguebackend.mapper.ScoreMapper;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayListEntryDTO;
import com.example.shaleaguebackend.service.ScoreService;
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
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public Page<PlayListEntryDTO> listPage(int currentPage, int pageSize) {
        return scoreMapper.listPage(new Page<PlayListEntryDTO>(currentPage,pageSize));
    }
}
