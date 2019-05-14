package com.example.fastdfs.service;

import com.example.fastdfs.dao.FDSAddressMapper;
import com.example.fastdfs.module.User;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class FastServiceImpl {

    @Autowired
    private FastFileStorageClient storageClient;
    @Resource
    private FDSAddressMapper fdsAddressMapper;

    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        String fileUrl = "http://45.32.64.33:8000" + "/" + storePath.getFullPath();
        if (!StringUtils.isEmpty(fileUrl)){
            Map<String, Object> map = new HashMap<>();
            map.put("address", fileUrl);
            fdsAddressMapper.insertAddress(map);
        }
        return fileUrl;
    }


}
