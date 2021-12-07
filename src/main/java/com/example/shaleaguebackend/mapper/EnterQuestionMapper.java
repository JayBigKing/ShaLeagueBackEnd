package com.example.shaleaguebackend.mapper;

import com.example.shaleaguebackend.model.domain.EnterQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jay
 * @since 2021-11-17
 */
public interface EnterQuestionMapper extends BaseMapper<EnterQuestion> {

    EnterQuestion getAQuestionByRand();
}
