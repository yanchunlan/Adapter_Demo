package com.example.adapter_demo.bean;

import java.io.Serializable;

/**
 * author:  ycl
 * date:  2019/09/03 15:23
 * desc:
 */
public class UserInfo implements Serializable {

    private String account;
    private String password;
    private int type; // 布局类型

    public UserInfo() {
    }

    public UserInfo(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String passeod) {
        this.password = passeod;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
