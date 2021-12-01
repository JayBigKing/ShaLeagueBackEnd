package com.example.shaleaguebackend.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shaleaguebackend.model.ErrorAbout.ErrorMap;
import com.example.shaleaguebackend.model.domain.NowSeason;
import com.example.shaleaguebackend.model.domain.PlayerImage;
import com.example.shaleaguebackend.model.domain.Score;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayListEntryDTO;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerDetails;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerDetails;
import com.example.shaleaguebackend.model.enums.RolesEnum;
import com.example.shaleaguebackend.service.NowSeasonService;
import com.example.shaleaguebackend.service.PlayerImageService;
import com.example.shaleaguebackend.service.ScoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.PlayerService;
import com.example.shaleaguebackend.model.domain.Player;

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
@RequestMapping("/api/player")
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger( PlayerController.class );

    @Autowired
    private PlayerService playerService;

    @Autowired
    private NowSeasonService nowSeasonService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private PlayerImageService playerImageService;

    RolesEnum rolesEnum;

    private static final String defaultImgSrc = "202111/default.png";

    private static final int defaultCurrentPage = 1;
    private static final int defaultPageSize = 20;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Player  player =  playerService.getById(id);
        return JsonResponse.success(player);
    }

    /**
     * 描述：根据Id 查询
     *
     */
    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getByName(@RequestParam("name") String name)throws Exception {
        Map<String, Object> map = listPageByName(name,defaultCurrentPage,defaultPageSize);
        return JsonResponse.success(map);
    }


    /**
     * 描述：根据Id 查询 细节
     *
     */
    @RequestMapping(value = "/getDetail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getDetailById(@PathVariable("id") Long id)throws Exception {
        PlayerDetails playerDetails = new PlayerDetails();
        Score score = scoreService.getByPid(id);
        Map<String,Object>map;
        playerDetails.setPlayerWInLoseCountDTO(playerService.getWinLoseDetailById(id));
        playerDetails.setPlayerLordCountDTO(playerService.getRolesDetailById(id,RolesEnum.THE_LORD));
        playerDetails.setPlayerCourtierCountDTO(playerService.getRolesDetailById(id,RolesEnum.THE_COURTIER));
        playerDetails.setPlayerRebelCountDTO(playerService.getRolesDetailById(id,RolesEnum.THE_REBEL));
        playerDetails.setPlayerTraitorCountDTO(playerService.getRolesDetailById(id,RolesEnum.THE_TRAITOR));

        map = playerDetails.getDetail();
        map.put("score",score.getScore());

        return JsonResponse.success(map);
        //return JsonResponse.success(player);
    }


    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        playerService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updatePlayer(@PathVariable("id") Long  id,Player  player) throws Exception {
        player.setPid(id);
        playerService.updateById(player);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Player
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Player  player) throws Exception {
        createOnePlayer(player,defaultImgSrc);
        return JsonResponse.success(null);
    }

    /**
     * 描述:创建Player
     *
     */
    @RequestMapping(value = "/withImg", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse createWithImg(Player  player , String imgSrc) throws Exception {
        if(imgSrc == null || imgSrc.equals(""))
            imgSrc = defaultImgSrc;
        createOnePlayer(player,imgSrc);
        return JsonResponse.success(null);
    }

    /**
     * 描述:修改Player
     *
     */
    @RequestMapping(value = "/renew", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse renew(@RequestBody Map<String, Object> models) throws Exception {

        String imgSrc = (String) models.get("imgSrc");
        Long thePid = Long.parseLong((String) models.get("pid"));
        String theName = (String) models.get("pname");


        Player  player =  playerService.getById(thePid);
        PlayerImage playerImage = playerImageService.getByPid(thePid);


        if(theName != null && !theName.equals(""))
            player.setName(theName);
        if(imgSrc != null && !imgSrc.equals(""))
            playerImage.setImgUrl(imgSrc);
        if(player == null)
            return JsonResponse.failure("没有这个id", ErrorMap.getErrorCode("没有这个id"));

        playerService.updateById(player);
        playerImageService.updateByPid(playerImage);

        return JsonResponse.success(null);
    }

    void createOnePlayer(Player player,String imgSrc){
        NowSeason nowSeason = nowSeasonService.getNowSeason();
        PlayerImage playerImage = new PlayerImage();
        Score score = new Score();
        playerService.save(player);
        score.setPid(player.getPid());
        score.setScore(0);
        score.setSid(nowSeason.getSid());
        scoreService.save(score);

        playerImage.setPid(player.getPid());
        playerImage.setImgUrl(imgSrc);
        playerImageService.save(playerImage);

    }

    private Map<String, Object> listPageByName(String name,int currentPage, int pageSize){
        Page<Player> page = (Page<Player>) playerService.listPageByName(name,currentPage,pageSize);
        List<Player> list = page.getRecords();
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
}

