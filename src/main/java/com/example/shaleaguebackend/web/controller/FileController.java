package com.example.shaleaguebackend.web.controller;


import com.example.shaleaguebackend.common.JsonResponse;
import com.example.shaleaguebackend.common.utls.SecurityUtils;
import com.example.shaleaguebackend.model.ErrorAbout.ErrorMap;
import com.example.shaleaguebackend.service.FileService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/file")
@Slf4j
public class FileController {
    protected FileService fileService;

    protected ResourceLoader resourceLoader;

    public FileController(FileService fileService, ResourceLoader resourceLoader) {
        this.fileService = fileService;
        this.resourceLoader = resourceLoader;
    }

    @ApiOperation(value = "文件上传", notes = "文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> upload(MultipartFile file, HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap();
//        if (SecurityUtils.getCurrentUserInfo() == null) {
//            map.put("message", "请登录后重试");
//            return ResponseEntity.badRequest().body(map);
//        }
        map = fileService.upload(file);
        return ResponseEntity.ok().body(map);
    }

    @ApiOperation(value = "文件删除", notes = "文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public JsonResponse deleteFile(@RequestBody Map<String, Object> models) throws IOException {
        if(fileService.deleteFile((String) models.get("fileStrEnd")) == true)
            return JsonResponse.success(null);
        else
            return JsonResponse.failure("没有这个文件", ErrorMap.getErrorCode("没有这个文件"));
    }

    private static String suffix(String fileName) {
        int i = fileName.lastIndexOf('.');
        return i == -1 ? "" : fileName.substring(i + 1);
    }

}
