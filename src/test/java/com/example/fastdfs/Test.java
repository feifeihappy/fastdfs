package com.example.fastdfs;

import com.alibaba.fastjson.JSON;
import com.example.fastdfs.module.User;

public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setCode("zpf");
        user.setName("赵鹏飞");
      String string =  JSON.toJSONString(user);
        System.out.println(string);

    }
}
