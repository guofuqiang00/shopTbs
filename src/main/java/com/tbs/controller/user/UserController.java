package com.tbs.controller.user;


import com.tbs.dao.user.UserDao;
import com.tbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    public String login(){


        return "/login/login";
    }

    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    @ResponseBody
    public List<User> selectUser(ModelAndView model){
        List<User> list = new ArrayList<User>();
        User user = userDao.selectUser();
        list.add(user);
        return list;
    }

    @RequestMapping(value = "/aa",method = RequestMethod.GET)
    @ResponseBody
    public String aa(){
        List<User> list = new ArrayList<User>();
        User user = userDao.selectUser();
        System.out.println(user.getUsername());
        System.out.println(user.getUserpassword());
        list.add(user);
        return "list";
    }


}
