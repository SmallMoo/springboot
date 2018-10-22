package com.blogx.entity;

import java.util.Date;

/**
 * @author XueYuan.
 * @date 2018/10/16 21:51.
 * Email: eoooxy@gmail.com.
 * PS: good good study day day up!
 */
public class Hello {

    private Integer id;
    private String name;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
