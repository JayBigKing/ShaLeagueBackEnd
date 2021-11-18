package com.example.shaleaguebackend.web.controller;

import com.example.shaleaguebackend.common.Judge;
import com.example.shaleaguebackend.common.utls.SessionUtils;
import com.example.shaleaguebackend.model.domain.Admin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.EnterQuestionService;
import com.example.shaleaguebackend.model.domain.EnterQuestion;

import java.util.Map;
import java.util.Random;


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
@RequestMapping("/api/enterQuestion")
public class EnterQuestionController {

    private final Logger logger = LoggerFactory.getLogger( EnterQuestionController.class );

    @Autowired
    private EnterQuestionService enterQuestionService;

    SessionUtils sessionUtils;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        EnterQuestion  enterQuestion =  enterQuestionService.getById(id);
        return JsonResponse.success(enterQuestion);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        enterQuestionService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateEnterQuestion(@PathVariable("id") Long  id,EnterQuestion  enterQuestion) throws Exception {
        enterQuestion.setQid(id);
        enterQuestionService.updateById(enterQuestion);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建EnterQuestion
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(EnterQuestion  enterQuestion) throws Exception {
        enterQuestionService.save(enterQuestion);
        return JsonResponse.success(null);
    }

    /**
     * 描述:创建EnterQuestion
     *
     */
    @RequestMapping(value = "/getAQuestionByRand", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAQuestionByRand() throws Exception {
        EnterQuestion enterQuestion = enterQuestionService.getAQuestionByRand();
        enterQuestion.setQanswer("");
        return JsonResponse.success(enterQuestion);
    }

    /**
     * 描述:创建EnterQuestion
     *
     */
    @RequestMapping(value = "/checkAnswer", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse checkAnswer(@RequestBody Map<String, Object> models) throws Exception {
        EnterQuestion  enterQuestion =  enterQuestionService.getById(Long.parseLong((String)models.get("id")));
        if(enterQuestion.getQanswer().equals((String)models.get("Qanswer"))){
            if(Judge.judgeSession() == 300){
                Random r = new Random();
                long  t = System.currentTimeMillis(); //获得当前时间的毫秒数
                r.setSeed(t);
                Admin admin = new Admin();
                admin.setOnlyId(Long.parseLong("-1"));


                sessionUtils.saveCurrentUserInfo(admin);                                    //存储用户信息到Session中
                System.out.println(admin.getId());
                //Admin             userInfo = SessionUtils.getCurrentUserInfo();
                sessionUtils.session(true);

            }
            return JsonResponse.success(null);
        }else{
            return JsonResponse.failure("回答错误",550);
        }

    }

}

