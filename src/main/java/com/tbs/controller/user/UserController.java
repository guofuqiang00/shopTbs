package com.tbs.controller.user;


import com.tbs.dao.user.UserDao;
import com.tbs.entity.User;
import com.tbs.utils.R;
import com.tbs.utils.UIDUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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
   public Map<String,Object> insertUser(User user){
        System.out.println(user);
        User user1 = new User();
        int num = userDao.insertUser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        return map;
    }

    @RequestMapping("/selectUserByMap")
    @ResponseBody
    public R selectUserByMap(@RequestBody Map<String,Object> params){
        List<User> users = userDao.selectUserByMap(params);
        return  R.ok().put("users",users);
    }
    
    @RequestMapping("/selectUserByMap2")
    @ResponseBody
    public R selectUserByMap2(@RequestBody Map<String,Object> params){
        List<User> users = userDao.selectUserByMap2(params);
        return  R.ok().put("users",users);
    }
    @RequestMapping("/selectUserByMap3")
    @ResponseBody
    public R selectUserByMap3(@RequestBody Map<String,Object> map,@RequestParam("password") String password){


        return  R.ok();
    }


    @RequestMapping("/selectUserByUser")
    @ResponseBody
    public R selectUserByUser(User user){
        List<User> users = userDao.selectUserByUser(user);
        return  R.ok().put("users",users);
    }

    @RequestMapping("/selectUserByUser2")
    @ResponseBody
    public R selectUserByUser2( User user){
        List<User> users = userDao.selectUserByUser(user);
        return  R.ok().put("users",users);
    }

    @RequestMapping("/selectUserByUser4")
    @ResponseBody
    public R selectUserByUser4( @RequestBody User user){



        return  R.ok();
    }
    @RequestMapping("/selectUserByUser5")
    @ResponseBody
    public R selectUserByUser5(User user){
        User user1 = new User();
        user1.setId(1713030994);
        user1.setUsername("4444");
        List<User> users = userDao.selectUserByUser5(user1, 0, 8);
        return R.ok().put("users",users);
    }


}
