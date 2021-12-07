package com.example.shaleaguebackend.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.MroleService;
import com.example.shaleaguebackend.model.domain.Mrole;


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
@RequestMapping("/api/mrole")
public class MroleController {

    private final Logger logger = LoggerFactory.getLogger( MroleController.class );

    @Autowired
    private MroleService mroleService;

    /**
    * 描述：根据Id 查询
    *
    */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
//        Mrole  mrole =  mroleService.getById(id);
//        return JsonResponse.success(mrole);
//    }


}

