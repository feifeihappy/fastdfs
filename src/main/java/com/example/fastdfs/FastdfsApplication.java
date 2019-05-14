package com.example.fastdfs;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

@Import(FdfsClientConfig.class)//注入FdfsClientConfig，就可以拥有带有连接池的FastDFS Java客户端了
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)//注解是为了解决JMX重复注册bean的问题
@MapperScan(basePackages="com.example.fastdfs.dao")
@SpringBootApplication
public class FastdfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastdfsApplication.class, args);
    }

}
