package com.yequan.dao;

import com.yequan.model.User;

public interface IUserDao {

    User selectUser(long id);

    boolean addOneUser(User user);

}
