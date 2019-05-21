package com.example.fastdfs.service;

import com.example.fastdfs.dao.FDSAddressMapper;
import com.example.fastdfs.utils.FastDFSUtils;
import com.github.tobato.fastdfs.domain.StorePath;
import com.sun.deploy.association.utility.AppConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class FastServiceImpl {

    @Resource
    private FDSAddressMapper fdsAddressMapper;
    @Resource
    private FastDFSUtils fastDFSUtils;

    @Value("${fdfsurl.url}")
    String fastdfsUrl;

    public String uploadFile(MultipartFile file)  {
        StorePath storePath = fastDFSUtils.getStorePath(file);
        String fileUrl = fastdfsUrl + "/" + storePath.getFullPath();
        if (!StringUtils.isEmpty(fileUrl)){
            Map<String, Object> map = new HashMap<>();
            map.put("address", fileUrl);
            map.put("createTime", new Date());
            fdsAddressMapper.insertAddress(map);
        }
        return fileUrl;
    }



    public void deleteFile(String file) {
        fastDFSUtils.deleteFile(file);

    }




}
