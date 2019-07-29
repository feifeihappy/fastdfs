package com.example.fastdfs.dao;

import com.example.fastdfs.module.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * 资源类
 *
 * @author oKong
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    Optional<User> findById(Long id);

    //使用自动命名规则进行查询服务
    List<User> findByCodeAndName(String code, String name);

    List<User> findUserByCode(String code);

    //分页
    Page<User> findByCode(String code, Pageable pageable);
    //使用@Query进行 自定义sql编写
    //nativeQuery=true,正常的sql语法
    //负责是hsql语法

    @Query(value = "select * from users where code = :code", nativeQuery = true)
    List<User> queryByCode(@Param("code") String code);

    List<User> findByNameContaining(String name);
}