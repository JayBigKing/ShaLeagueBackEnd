package com.example.shaleaguebackend.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.SeasonService;
import com.example.shaleaguebackend.model.domain.Season;


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
@RequestMapping("/api/season")
public class SeasonController {

    private final Logger logger = LoggerFactory.getLogger( SeasonController.class );

    @Autowired
    private SeasonService seasonService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Season  season =  seasonService.getById(id);
        return JsonResponse.success(season);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        seasonService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateSeason(@PathVariable("id") Long  id,Season  season) throws Exception {
        season.setSid(id);
        seasonService.updateById(season);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Season
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Season  season) throws Exception {
        seasonService.save(season);
        return JsonResponse.success(null);
    }
}

