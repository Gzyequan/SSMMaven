package com.yequan.service.impl;

import com.yequan.dao.IUserDao;
import com.yequan.model.User;
import com.yequan.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectUserId(long id) {
        return this.userDao.selectUserById(id);
    }

    @Override
    public User selectUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }

    @Override
    public boolean addOneUser(User user) {
        return this.userDao.addOneUser(user);
    }

    @Override
    public User checkEmailAndPassword(String email, String password) {
        return this.userDao.checkEmailAndPassword(email, password);
    }
}
