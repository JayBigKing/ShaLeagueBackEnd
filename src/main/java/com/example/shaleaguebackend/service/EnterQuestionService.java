package com.example.shaleaguebackend.service;

import com.example.shaleaguebackend.model.domain.EnterQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jay
 * @since 2021-11-17
 */
public interface EnterQuestionService extends IService<EnterQuestion> {

    EnterQuestion getAQuestionByRand();
}
