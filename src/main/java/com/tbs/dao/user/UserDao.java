package com.tbs.dao.user;


import com.tbs.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

   List<User>  selectUser();

   int insertUser(@Param("user") User user);

}
