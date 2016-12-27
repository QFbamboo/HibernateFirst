package cn.bamboo.entity;

import java.util.Date;

/**
 * User实体类
 * Created by p1411 on 2016/12/22.
 */
public class User {

    private int id;
    private String username;
    private String birthday;
    private String sex;
    private String address;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }
}
