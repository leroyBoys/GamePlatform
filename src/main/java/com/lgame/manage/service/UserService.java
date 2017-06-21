package com.lgame.manage.service;

import com.lgame.model.User;
import com.module.db.UserDev;
import com.module.db.UserFrom;
import com.module.db.UserInfo;
import com.module.net.DB;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface UserService {
    public User getUser(String name);

    public int insertUser(User user);
}
