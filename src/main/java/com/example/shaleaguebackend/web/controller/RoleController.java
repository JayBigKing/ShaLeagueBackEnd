package com.example.shaleaguebackend.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.service.RoleService;
import com.example.shaleaguebackend.model.domain.Role;


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
@RequestMapping("/api/role")
public class RoleController {

    private final Logger logger = LoggerFactory.getLogger( RoleController.class );

    @Autowired
    private RoleService roleService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Role  role =  roleService.getById(id);
        return JsonResponse.success(role);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        roleService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateRole(@PathVariable("id") Long  id,Role  role) throws Exception {
        role.setRid(id);
        roleService.updateById(role);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Role
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Role  role) throws Exception {
        roleService.save(role);
        return JsonResponse.success(null);
    }
}

