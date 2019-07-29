package com.example.fastdfs.controller;

import com.alibaba.fastjson.JSON;
import com.example.fastdfs.dao.UserDao;
import com.example.fastdfs.module.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 测试类
 *
 * @author
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    UserDao userDao;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        log.info("新增用户:{}", user);
        try {
            user = userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "新增成功，返回用户id为：" + user.getId();
    }

    @GetMapping("/find/{id}")
    public Optional<User> findUser(@PathVariable Long id) {
        log.info("查找用户ID:{}", id);
        return userDao.findById(id);
    }

    @GetMapping("/del/{id}")
    public String delUser(@PathVariable Long id) {
        log.info("删除用户ID:{}", id);
        userDao.deleteById(id);
        return "用户id为：" + id + "，已被删除!";
    }

    @GetMapping("/findName")
    public List<User> findUserByCodeAndName(@RequestParam("code") String code, @RequestParam("name") String name) {
        log.info("命名规则方式，查找用户:编码：{}，名称：{}", code, name);
        return userDao.findByCodeAndName(code, name);
    }
    @GetMapping("/findNameTest")
    public List<User> findUserByCode(@RequestParam("code") String code,@RequestParam("name") String name) {
//        log.info("命名规则方式，查找用户:编码：{}，名称：{}", code, name);
        List<User> list = userDao.findByNameContaining(name);
        String result = JSON.toJSONString(list);
        log.info(result);
        return userDao.findUserByCode(code);
    }

    @GetMapping("/find/paging/{code}")
    public Page<User> findUserByCodePagin(@PathVariable("code") String code) {
        log.info("分页模式，查找用户:编码：{}", code);
        //这里注意 page是从0开始的
        return userDao.findByCode(code, new PageRequest(0, 10));
    }

    @GetMapping("/find/sql/{code}")
    public List<User> findUserByQuerySql(@PathVariable("code") String code) {
        log.info("自定义sql方式，查找用户:编码：{}", code);

        return userDao.queryByCode(code);
    }
}
