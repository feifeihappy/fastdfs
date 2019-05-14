package com.example.fastdfs.controller;

import com.example.fastdfs.service.FastServiceImpl;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



/**
* @Description: fastDFS文件上传
* @Author: zhaopf@mti-sh.cn
* @Date: 2019/5/10 10:31
*/
@RestController
@Slf4j
public class FastController {

    @Autowired
    private FastServiceImpl fastService;

    // 上传文件
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile file) throws Exception {
        String fileUrl= null;
        try {
            fileUrl = fastService.uploadFile(file);
        } catch (Exception e) {
            log.error(e.getMessage());

        }
        return fileUrl;
    }
}
