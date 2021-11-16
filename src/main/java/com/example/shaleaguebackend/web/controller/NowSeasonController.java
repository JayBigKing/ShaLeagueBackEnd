package com.example.shaleaguebackend.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.NowSeasonService;
import com.example.shaleaguebackend.model.domain.NowSeason;


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
@RequestMapping("/api/nowSeason")
public class NowSeasonController {

    private final Logger logger = LoggerFactory.getLogger( NowSeasonController.class );

    @Autowired
    private NowSeasonService nowSeasonService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        NowSeason  nowSeason =  nowSeasonService.getById(id);
        return JsonResponse.success(nowSeason);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        nowSeasonService.removeById(id);
        return JsonResponse.success(null);
    }




    /**
    * 描述:创建NowSeason
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(NowSeason  nowSeason) throws Exception {
        nowSeasonService.save(nowSeason);
        return JsonResponse.success(null);
    }
}

