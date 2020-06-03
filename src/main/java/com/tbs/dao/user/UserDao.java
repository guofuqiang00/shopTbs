package com.tbs.dao.user;


import com.tbs.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

   List<User>  selectUser();

   int insertUser(User user);

   List<User> selectUserByMap(Map map);

   List<User> selectUserByMap2(@Param("params") Map map);

   List<User> selectUserByUser(@Param("user") User user);


}
