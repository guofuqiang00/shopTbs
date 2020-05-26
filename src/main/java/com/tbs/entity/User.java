package com.tbs.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class User  {
    private String username;
    private String password;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
