package com.example.shaleaguebackend.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.PlayerImageService;
import com.example.shaleaguebackend.model.domain.PlayerImage;


/**
 *
 *  前端控制器
 *
 *
 * @author jay
 * @since 2021-11-17
 * @version v1.0
 */
@Controller
@RequestMapping("/api/playerImage")
public class PlayerImageController {

    private final Logger logger = LoggerFactory.getLogger( PlayerImageController.class );

    @Autowired
    private PlayerImageService playerImageService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        PlayerImage  playerImage =  playerImageService.getById(id);
        return JsonResponse.success(playerImage);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        playerImageService.removeById(id);
        return JsonResponse.success(null);
    }





    /**
    * 描述:创建PlayerImage
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(PlayerImage  playerImage) throws Exception {
        playerImageService.save(playerImage);
        return JsonResponse.success(null);
    }
}

