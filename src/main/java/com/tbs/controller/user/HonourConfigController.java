package com.tbs.controller.user;

import com.tbs.entity.HonourConfig;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping(value = "/honourConfig")
@RestController
public class HonourConfigController {
    @RequestMapping("/list")
    public Map<String, Object> list(){
      List<HonourConfig> list = new ArrayList<>();
      HonourConfig honourConfig = new HonourConfig();
        honourConfig.setGoodsId(1000001L);  //商品id
        honourConfig.setGoodsObjectId(200001L);//商品活动Id
        honourConfig.setGoodsType(1);
        honourConfig.setGoodsName("手机"); //商品名称
        honourConfig.setGoodsActivityName("前端显示的名称");
        honourConfig.setStartTime(new Date());//开始时间
        honourConfig.setEndTime(new Date()); //结束时间
        honourConfig.setHomeActivityImageUrl("http://www.xxxx.com/img"); //首页活动图
        honourConfig.setStatus(1);
        honourConfig.setCreateTime(new Date());//创建时间
        honourConfig.setUpdatedTime(new Date()); //更新时间
        honourConfig.setUpdateBy("xxx"); //更新人
        list.add(honourConfig);
        Map<String,Object> map = new HashMap();
        map.put("data",list);
        map.put("code", 0);
        map.put("msg", "成功");
        return map;
    }

    @RequestMapping("/save" )
     public void save(@RequestBody HonourConfig honourConfig){

      System.out.println(honourConfig);

    }
}
