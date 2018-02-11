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
    public User selectUser(long id) {
        return this.userDao.selectUser(id);
    }

    @Override
    public boolean addOneUser(User user) {
        return this.userDao.addOneUser(user);
    }
}
