package com.example.shaleaguebackend;

import com.example.shaleaguebackend.model.domain.Admin;
import com.example.shaleaguebackend.model.domain.RoleScoreMap;
import com.example.shaleaguebackend.service.AdminService;
import com.example.shaleaguebackend.service.RoleScoreMapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private RoleScoreMapService roleScoreMapService;
    @Test
    void contextLoads() {
        RoleScoreMap roleScoreMap = roleScoreMapService.getRoleScoreMap();
        System.out.println(roleScoreMap.getLordScore());
    }

}
