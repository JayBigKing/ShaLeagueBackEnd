package com.example.shaleaguebackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shaleaguebackend.mapper.PlayerMapper;
import com.example.shaleaguebackend.model.domain.RoleScoreMap;
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

    @Override
    public Score getByPid(Long pid) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("Pid",pid);
        Score score  = this.getOne(wrapper);
        return score;
    }

    @Override
    public void updateScoreAfterMatchSha(Long Sid, Long Pid, int theRole, int result, RoleScoreMap roleScoreMap, int givenScore) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("Pid",Pid).eq("Sid",Sid);
        Score score  = this.getOne(wrapper);
        if(givenScore == -1)
            switch (theRole){
                case 0:
                    score.setScore(score.getScore() + roleScoreMap.getLordScore() * result);
                    break;
                case 1:
                    score.setScore(score.getScore() + roleScoreMap.getCourtierScore() * result);
                    break;
                case 2:
                    score.setScore(score.getScore() + roleScoreMap.getRebelScore() * result);
                    break;
                case 3:
                    score.setScore(score.getScore() + roleScoreMap.getTraitorScore() * result);
                    break;
                default:break;
            }
        else
            score.setScore(score.getScore() + givenScore);
        this.updateById(score);
    }
}
