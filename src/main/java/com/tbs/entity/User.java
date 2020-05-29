package com.tbs.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class User  {
    private Integer id;
    private String username;
    private String password;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;


}
