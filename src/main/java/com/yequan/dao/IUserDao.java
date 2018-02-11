package com.yequan.dao;

import com.yequan.model.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {

    User selectUserById(long id);

    User selectUserByEmail(String email);

    boolean addOneUser(User user);

    User checkEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
