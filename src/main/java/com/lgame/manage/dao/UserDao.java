package com.lgame.manage.dao;

import com.lgame.model.User;
import com.module.db.UserDev;
import com.module.db.UserFrom;
import com.module.db.UserInfo;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface UserDao {
    public User getUser(String name);

    public int insertUser(User user);
}
