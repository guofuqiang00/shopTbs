package com.tbs.dao.user;


import com.tbs.entity.User;

import java.util.List;

public interface UserDao {

   List<User>  selectUser();

   int insertUser(User user);

}
