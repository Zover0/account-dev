package com.zover.pojo;

import javax.persistence.Id;
import java.util.Date;

public class Account {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 日期
     */
    private Date date;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取金额
     *
     * @return money - 金额
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置金额
     *
     * @param money 金额
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * 获取日期
     *
     * @return date - 日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置日期
     *
     * @param date 日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}