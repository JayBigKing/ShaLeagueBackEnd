package com.example.shaleaguebackend.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shaleaguebackend.model.MyTime.MyTimeHelp;
import com.example.shaleaguebackend.model.domain.*;
import com.example.shaleaguebackend.model.dto.MatchShaDTOs.MatchShaDTO;
import com.example.shaleaguebackend.model.dto.RoleDTOs.RoleFrontDTO;
import com.example.shaleaguebackend.model.enums.RolesEnum;
import com.example.shaleaguebackend.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;

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
@RequestMapping("/api/matchSha")
public class MatchShaController {

    private final Logger logger = LoggerFactory.getLogger( MatchShaController.class );

    @Autowired
    private MatchShaService matchShaService;

    @Autowired
    private NowSeasonService nowSeasonService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleScoreMapService roleScoreMapService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private MroleService mroleService;

    RolesEnum rolesEnum;
    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        MatchSha  matchSha =  matchShaService.getById(id);
        return JsonResponse.success(matchSha);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        matchShaService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateMatchSha(@PathVariable("id") Long  id,MatchSha  matchSha) throws Exception {
        matchSha.setMid(id);
        matchShaService.updateById(matchSha);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建MatchSha
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody MatchShaDTO matchShaDTO) throws Exception {
        NowSeason nowSeason = nowSeasonService.getNowSeason();
        RoleScoreMap roleScoreMap = roleScoreMapService.getRoleScoreMap();
        MatchSha matchSha = new MatchSha();
        //matchSha.getMdate();
        matchSha.setMdate(MyTimeHelp.getNowDateTime());
        matchSha.setSid(nowSeason.getSid());
        matchSha.setPid(Long.parseLong(matchShaDTO.getWinner()));

        matchShaService.save(matchSha);

        for(RoleFrontDTO item : matchShaDTO.getRoles()){
            //添加role
            Role role = new Role();
            Mrole mrole = new Mrole();
            role.setPid(Long.parseLong(item.getId()));
            role.setMid(matchSha.getMid());
            role.setSid(nowSeason.getSid());
            role.setRTheRole(item.getTheRole());
            if(item.getResult() == 0)
                role.setRresult(Boolean.FALSE);
            else
                role.setRresult(Boolean.TRUE);

            roleService.save(role);

            if(item.getMgid() != null && !item.getMgid().equals("")){
                mrole.setRid(role.getRid());
                mrole.setMGid(Long.parseLong(item.getMgid()));
                mroleService.save(mrole);
            }

            //更新积分
            scoreService.updateScoreAfterMatchSha(nowSeason.getSid(),Long.parseLong(item.getId()),item.getTheRole(),item.getResult(),roleScoreMap,item.getGivenScore());



        }



//        for(RoleFrontDTO item : roles){
//            Role role = new Role();
//            role.setPid(Long.parseLong(item.getId()));
//            role.setMid(matchSha.getMid());
//            role.setSid(nowSeason.getSid());
//            role.setRTheRole(item.getTheRole());
//            if(item.getResult() == 0)
//                role.setRresult(Boolean.FALSE);
//            else
//                role.setRresult(Boolean.TRUE);
//
//            roleService.save(role);
//        }

        return JsonResponse.success(null);
    }

    /**
     * 描述:创建MatchSha
     *
     */
    @RequestMapping(value = "/createOnlyOneMatchSha", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse createOnlyOneMatchSha() throws Exception{
        NowSeason nowSeason = nowSeasonService.getNowSeason();
        MatchSha matchSha = new MatchSha();
        //matchSha.getMdate();
        matchSha.setMdate(MyTimeHelp.getNowDateTime());
        matchSha.setSid(nowSeason.getSid());
        matchShaService.save(matchSha);
        return JsonResponse.success(matchSha);
    }

//    void updateScoreAfterMatchSha(Long Sid, Long Pid , int theRole , int result , RoleScoreMap roleScoreMap , int givenScore){
//
//        QueryWrapper<Score> wrapper = new QueryWrapper<>();
//        wrapper.eq("Pid",Pid).eq("Sid",Sid);
//        Score score  = scoreService.getOne(wrapper);
//        if(givenScore == -1)
//        switch (theRole){
//            case 0:
//                score.setScore(score.getScore() + roleScoreMap.getLordScore() * result);
//                break;
//            case 1:
//                score.setScore(score.getScore() + roleScoreMap.getCourtierScore() * result);
//                break;
//            case 2:
//                score.setScore(score.getScore() + roleScoreMap.getRebelScore() * result);
//                break;
//            case 3:
//                score.setScore(score.getScore() + roleScoreMap.getTraitorScore() * result);
//                break;
//            default:break;
//        }
//        else
//            score.setScore(score.getScore() + givenScore);
//        scoreService.updateById(score);
//
//    }
}

