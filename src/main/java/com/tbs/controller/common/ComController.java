package com.tbs.controller.common;

import com.tbs.entity.Common;
import com.tbs.utils.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/com")
public class ComController {


    @RequestMapping("/select")
    public R select(@RequestBody HashMap params){
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(params);
        return R.ok().put("data",list);
    }

    @RequestMapping("/selectCommon")
    public R selectCommon(@RequestBody Common params){
        List<Common> list = new ArrayList<>();
        list.add(params);
        return R.ok().put("data",list);
    }
    @RequestMapping("/selectCommonByParams")
    public R selectCommonByParams(@RequestParam("id") Long id){
        List<Common> list = new ArrayList<>();
        return R.ok().put("data",id);
    }

}
