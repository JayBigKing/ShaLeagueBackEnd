package com.example.shaleaguebackend.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.AdminService;
import com.example.shaleaguebackend.model.domain.Admin;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-04-19
 */

//@RestController
//@RequestMapping("/api/admin")
//public class AdminController {
//
//    private final Logger logger = LoggerFactory.getLogger( AdminController.class );
//
//    @Autowired
//    private AdminService adminService;
//
//    /**
//    * 描述：根据Id 查询
//    *
//    */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
//        Admin  admin =  adminService.getById(id);
//        return JsonResponse.success(admin);
//    }
//
//    /**
//    * 描述：根据Id删除
//    *
//    */
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
//        adminService.removeById(id);
//        return JsonResponse.success(null);
//    }
//
//
//    /**
//    * 描述：根据Id 更新
//    *
//    */
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    public JsonResponse updateAdmin(@PathVariable("id") Long  id,Admin  admin) throws Exception {
//        admin.setId(id);
//        adminService.updateById(admin);
//        return JsonResponse.success(null);
//    }
//
//
//    /**
//    * 描述:创建Admin
//    *
//    */
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonResponse create(Admin  admin) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        admin.setPassword(encoder.encode(admin.getPassword()));
//        adminService.save(admin);
//        return JsonResponse.success(null);
//    }
//    @RequestMapping("/list")
//    @ResponseBody
//    public JsonResponse list(Model model,
//                             @RequestParam(required = false,defaultValue = "1") Integer pageNo,
//                             @RequestParam(required = false,defaultValue = "10")Integer pageSize){
//        Page<Admin> page = adminService.page(new Page<>(pageNo, pageSize));
//
//        return JsonResponse.success(page);
//    }
//
//    @RequestMapping("/deleteByIds")
//    @ResponseBody
//    public JsonResponse deleteByIds(@RequestParam("ids[]")List<Integer> ids){
//        adminService.removeByIds(ids);
//        return JsonResponse.success( null);
//    }
//
//    @GetMapping("/login")
//    public JsonResponse login(Admin admin, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
//        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(Admin::getLoginName,admin.getLoginName()).eq(Admin::getPassword,admin.getPassword());
//        Admin one = adminService.getOne(queryWrapper);
//        return  JsonResponse.success(one);
//    }
//}
//
