package com.example.shaleaguebackend.web.controller;


import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.common.utls.SecurityUtils;
import com.example.shaleaguebackend.common.utls.SessionUtils;
import com.example.shaleaguebackend.model.domain.Admin;
import com.example.shaleaguebackend.model.dto.UserInfoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @GetMapping("/userInfo")
    public JsonResponse<UserInfoDTO> getUserInfo() {
        return JsonResponse.success(SecurityUtils.getUserInfo());
    }
    @GetMapping("/adminInfo")
    public JsonResponse<Admin> getAdminInfo() {
        Admin admin;
        if(SessionUtils.session(false) != null)
            admin = SessionUtils.getCurrentUserInfo();
        else{
            admin = new Admin();
            admin.setOnlyId(Long.parseLong("-1"));
        }
        return JsonResponse.success(admin);
    }
}
