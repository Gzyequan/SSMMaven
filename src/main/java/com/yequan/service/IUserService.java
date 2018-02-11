package com.yequan.service;

import com.yequan.model.User;

public interface IUserService {
    public User selectUser(long id);
    public boolean addOneUser(User user);
}
