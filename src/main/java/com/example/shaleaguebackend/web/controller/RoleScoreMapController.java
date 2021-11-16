package com.example.shaleaguebackend.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.RoleScoreMapService;
import com.example.shaleaguebackend.model.domain.RoleScoreMap;


/**
 *
 *  前端控制器
 *
 *
 * @author jay
 * @since 2021-11-16
 * @version v1.0
 */
@Controller
@RequestMapping("/api/roleScoreMap")
public class RoleScoreMapController {

    private final Logger logger = LoggerFactory.getLogger( RoleScoreMapController.class );

    @Autowired
    private RoleScoreMapService roleScoreMapService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        RoleScoreMap  roleScoreMap =  roleScoreMapService.getById(id);
        return JsonResponse.success(roleScoreMap);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        roleScoreMapService.removeById(id);
        return JsonResponse.success(null);
    }





    /**
    * 描述:创建RoleScoreMap
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(RoleScoreMap  roleScoreMap) throws Exception {
        roleScoreMapService.save(roleScoreMap);
        return JsonResponse.success(null);
    }
}

