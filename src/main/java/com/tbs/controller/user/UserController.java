package com.tbs.controller.user;


import com.tbs.dao.user.UserDao;
import com.tbs.entity.User;
import com.tbs.utils.R;
import com.tbs.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    public String login(){


        return "/login/login";
    }

    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    @ResponseBody
    public R selectUser(){
        List<User> users = userDao.selectUser();
        return R.ok().put("data",users);
    }

    @RequestMapping("/insertUser")
    @ResponseBody
   public R insertUser(@RequestBody User user){
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin");
        int num = userDao.insertUser(user1);
        return R.ok();
    }


}
