package com.yequan.service;

import com.yequan.model.User;

public interface IUserService {
    public User selectUserId(long id);

    public User selectUserByEmail(String email);

    public boolean addOneUser(User user);

    public User checkEmailAndPassword(String email, String password);
}
