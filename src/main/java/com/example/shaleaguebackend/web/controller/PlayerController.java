package com.example.shaleaguebackend.web.controller;

import com.example.shaleaguebackend.model.domain.NowSeason;
import com.example.shaleaguebackend.model.domain.Score;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerDetails;
import com.example.shaleaguebackend.model.dto.PlayerDTOs.PlayerDetails;
import com.example.shaleaguebackend.model.enums.RolesEnum;
import com.example.shaleaguebackend.service.NowSeasonService;
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

    RolesEnum rolesEnum;

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
     * 描述：根据Id 查询 细节
     *
     */
    @RequestMapping(value = "/getDetail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getDetailById(@PathVariable("id") Long id)throws Exception {
        PlayerDetails playerDetails = new PlayerDetails();
        playerDetails.setPlayerWInLoseCountDTO(playerService.getWinLoseDetailById(id));
        playerDetails.setPlayerLordCountDTO(playerService.getRolesDetailById(id,RolesEnum.THE_LORD));
        playerDetails.setPlayerCourtierCountDTO(playerService.getRolesDetailById(id,RolesEnum.THE_COURTIER));
        playerDetails.setPlayerRebelCountDTO(playerService.getRolesDetailById(id,RolesEnum.THE_REBEL));
        playerDetails.setPlayerTraitorCountDTO(playerService.getRolesDetailById(id,RolesEnum.THE_TRAITOR));
        return JsonResponse.success(playerDetails.getDetail());
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
        NowSeason nowSeason = nowSeasonService.getNowSeason();
        Score score = new Score();
        playerService.save(player);
        score.setPid(player.getPid());
        score.setScore(0);
        score.setSid(nowSeason.getSid());
        scoreService.save(score);
        return JsonResponse.success(null);
    }
}

