package com.example.shaleaguebackend.service.impl;

import com.example.shaleaguebackend.model.domain.EnterQuestion;
import com.example.shaleaguebackend.mapper.EnterQuestionMapper;
import com.example.shaleaguebackend.service.EnterQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jay
 * @since 2021-11-17
 */
@Service
public class EnterQuestionServiceImpl extends ServiceImpl<EnterQuestionMapper, EnterQuestion> implements EnterQuestionService {

    @Autowired
    private EnterQuestionMapper enterQuestionMapper;

    @Override
    public EnterQuestion getAQuestionByRand() {
        return enterQuestionMapper.getAQuestionByRand();
    }
}
