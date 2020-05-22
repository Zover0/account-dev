package com.zover.pojo;

import javax.persistence.Id;

public class User {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 用户名 用户名
     */
    private String name;

    /**
     * 密码 密码
     */
    private String password;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名 用户名
     *
     * @return name - 用户名 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名 用户名
     *
     * @param name 用户名 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取密码 密码
     *
     * @return password - 密码 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码 密码
     *
     * @param password 密码 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}