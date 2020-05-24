package com.tbs.controller.user;


import com.tbs.dao.user.UserDao;
import com.tbs.entity.User;
import com.tbs.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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




}
