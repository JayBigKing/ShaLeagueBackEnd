package com.example.shaleaguebackend.service.impl;

import com.example.shaleaguebackend.model.domain.Admin;
import com.example.shaleaguebackend.mapper.AdminMapper;
import com.example.shaleaguebackend.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-04-19
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
