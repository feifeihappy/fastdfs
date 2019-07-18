package com.example.fastdfs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 测试
 * @Author: zhaopf@mti-sh.cn
 * @Date: 2019/7/5 10:47
 */
@RestController
@Slf4j
public class TestController {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String upload() {
        log.info("请求成功");
        String[] strings = {"1","2"};
        String s = strings[3];

        return "请求成功";
    }


}
