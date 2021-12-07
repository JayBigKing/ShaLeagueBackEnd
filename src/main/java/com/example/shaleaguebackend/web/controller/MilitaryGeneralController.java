package com.example.shaleaguebackend.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.MilitaryGeneralService;
import com.example.shaleaguebackend.model.domain.MilitaryGeneral;

import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author jay
 * @since 2021-12-01
 * @version v1.0
 */
@Controller
@RequestMapping("/api/militaryGeneral")
public class MilitaryGeneralController {

    private final Logger logger = LoggerFactory.getLogger( MilitaryGeneralController.class );

    @Autowired
    private MilitaryGeneralService militaryGeneralService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        MilitaryGeneral  militaryGeneral =  militaryGeneralService.getById(id);
        return JsonResponse.success(militaryGeneral);
    }

    /**
     * 描述：根据Id 查询
     *
     */
    @RequestMapping(value = "/byName", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getByName(@RequestParam("name") String name)throws Exception {
        QueryWrapper<MilitaryGeneral> wrapper = new QueryWrapper<>();
        wrapper.like("MGname",name);
        List<MilitaryGeneral> militaryGenerals  = militaryGeneralService.list(wrapper);
        return JsonResponse.success(militaryGenerals);
    }

}

