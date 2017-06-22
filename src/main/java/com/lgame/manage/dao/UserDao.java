package com.lgame.manage.dao;

import com.lgame.model.*;
import com.module.db.UserAttrbute;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface UserDao {
    public User getUser(String name);

    public int insertUser(User user);

    public List<UrlMenu> getAllUrlMenus();

    public int insertIntoUrlMenu(UrlMenu urlMenu);

    public Set<Integer> getUrlsByGroup(int group);

    public boolean insertIntoGroupLimit(GroupLimit limit);

    public List<UserLimit> getUserLimitByUid(int uid);
    public boolean insertUserLimit(UserLimit userLimit);
    public UserAttrbute getUserAttrbute(int uid);
    public int insertUserAttribute(UserAttrbute userAttrbute);

    public List<UserGroup> getUserGroups();
    public int insertUserGroup(UserGroup userGroup);

}
