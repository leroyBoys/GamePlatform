package com.lgame.manage.service.impl;

import com.lgame.manage.dao.UserDao;
import com.lgame.manage.dao.UserRedis;
import com.lgame.manage.service.UserService;
import com.lgame.model.*;
import com.lgame.util.comm.StringTool;
import com.module.db.UserAttrbute;
import com.module.db.UserDev;
import com.module.db.UserFrom;
import com.module.db.UserInfo;
import com.module.net.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<UrlMenu> getAllUrlMenus() {
        return userDao.getAllUrlMenus();
    }

    @Override
    public int insertIntoUrlMenu(UrlMenu urlMenu) {
        return userDao.insertIntoUrlMenu(urlMenu);
    }

    @Override
    public Set<Integer> getUrlsByGroup(int group) {
        return userDao.getUrlsByGroup(group);
    }

    @Override
    public boolean insertIntoGroupLimit(GroupLimit limit) {
        return userDao.insertIntoGroupLimit(limit);
    }

    @Override
    public List<UserLimit> getUserLimitByUid(int uid) {
        return userDao.getUserLimitByUid(uid);
    }

    @Override
    public boolean insertUserLimit(UserLimit userLimit) {
        return userDao.insertUserLimit(userLimit);
    }

    @Override
    public UserAttrbute getUserAttrbute(int uid) {
        return userDao.getUserAttrbute(uid);
    }

    @Override
    public int insertUserAttribute(UserAttrbute userAttrbute) {
        return userDao.insertUserAttribute(userAttrbute);
    }

    @Override
    public List<UserGroup> getUserGroups() {
        return userDao.getUserGroups();
    }

    @Override
    public int insertUserGroup(UserGroup userGroup) {
        return userDao.insertUserGroup(userGroup);
    }
}
