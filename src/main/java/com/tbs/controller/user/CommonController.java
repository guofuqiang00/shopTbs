package com.tbs.controller.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController {




    @RequestMapping("/select")
    public Map<String,Object>  select(@RequestBody String json){
        Map<String,Object> map = new HashMap<>();



        return map;
    }


}
