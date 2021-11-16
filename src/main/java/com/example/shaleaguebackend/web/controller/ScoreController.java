package com.example.shaleaguebackend.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayListEntryDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.ScoreService;
import com.example.shaleaguebackend.model.domain.Score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
@RequestMapping("/api/score")
public class ScoreController {

    private final Logger logger = LoggerFactory.getLogger( ScoreController.class );

    @Autowired
    private ScoreService scoreService;

    private static final int defaultCurrentPage = 1;
    private static final int defaultPageSize = 20;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Score  score =  scoreService.getById(id);
        return JsonResponse.success(score);
    }



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getByList()throws Exception {
        return JsonResponse.success(listPage(defaultCurrentPage,defaultPageSize));
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        scoreService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateScore(@PathVariable("id") Long  id,Score  score) throws Exception {
        score.setSCid(id);
        scoreService.updateById(score);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Score
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Score  score) throws Exception {
        scoreService.save(score);
        return JsonResponse.success(null);
    }


    private Map<String, Object> listPage(int currentPage, int pageSize){
        Page<PlayListEntryDTO> page = (Page<PlayListEntryDTO>) scoreService.listPage(currentPage,pageSize);
        List<PlayListEntryDTO> list = page.getRecords();
        Map<String,Object>map = new HashMap<>();
        map.put("data",list);
        map.put("totalData",page.getTotal());
        map.put("current",page.getCurrent());
        map.put("totalPages",page.getPages());
        map.put("pageSize",page.getSize());
        map.put("hasPrevious",page.hasPrevious());
        map.put("hasNext",page.hasNext());
        return map;
    }
    /*
    *     @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody Map<String, Object> models) throws Exception {
        Consultant consultant = new Consultant();

        consultant.setCid((String)models.get("id"));
        consultant.setCname((String)models.get("name"));
        consultant.setCmail((String)models.get("mail"));
        consultant.setCphoneNumber((String)models.get("phone_num"));
        consultant.setCpassword("123456");
    * */

}

