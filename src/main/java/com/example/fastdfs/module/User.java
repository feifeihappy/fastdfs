package com.example.fastdfs.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 * @author zpf
 *
 */
@Entity//@Entity 是一个必选的注解，声明这个类对应了一个数据库表。
@Table(name="users")//自定义表名,如果没有指定，则表名和实体的名称保持一致。
@Getter
@Setter
public class User implements Serializable {

    /**
     * 唯一标示
     */
    @Id //@Id 注解声明了实体唯一标识对应的属性。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 编码
     */
    @Column
    private String code;
    /**
     * 名称
     */
    @Column
    private String name;

    /**
     * 创建时间
     */
    @Column
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @Column
    private Date gmtModified;
}