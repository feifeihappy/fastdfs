package com.example.fastdfs.controller;

import com.example.fastdfs.service.FastServiceImpl;
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

    /**
     * 上传单个文件
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile file) throws Exception {
        String fileUrl = null;
        try {
            fileUrl = fastService.uploadFile(file);
        } catch (Exception e) {
            log.error(e.getMessage());

        }
        return fileUrl;
    }


    /**
     * 上传多个文件
     * @param files
     * @return
     */
    @RequestMapping(value = "/uploadList",method = RequestMethod.POST)
    public String addUser(@RequestParam MultipartFile[] files) {
        StringBuilder result = null;
        try {
             result = new StringBuilder();
            for (int i = 0; i < files.length; i++) {
                String fileUrl = fastService.uploadFile(files[i]);
                result.append(fileUrl);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return String.valueOf(result);
    }


   /**
   * @Description: 删除文件
   * @Author: zhaopf@mti-sh.cn
   * @Date: 2019/5/21 11:04
   */
    @RequestMapping(value = "/deleteFile", method = RequestMethod.GET)
    public void deleteFile(@RequestParam String file) {
        try {
           fastService.deleteFile(file);
        } catch (Exception e) {
            log.error(e.getMessage());

        }
    }

}
