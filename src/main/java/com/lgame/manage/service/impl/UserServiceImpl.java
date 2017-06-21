package com.lgame.manage.service.impl;

import com.lgame.manage.dao.UserDao;
import com.lgame.manage.dao.UserRedis;
import com.lgame.manage.service.UserService;
import com.lgame.model.User;
import com.lgame.util.comm.StringTool;
import com.module.db.UserDev;
import com.module.db.UserFrom;
import com.module.db.UserInfo;
import com.module.net.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/7.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRedis userRdis;

    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
