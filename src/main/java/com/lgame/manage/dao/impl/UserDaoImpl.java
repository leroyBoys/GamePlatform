package com.lgame.manage.dao.impl;

import com.lgame.base.dao.BaseDao;
import com.lgame.manage.dao.UserDao;
import com.lgame.model.User;
import com.lgame.util.comm.StringTool;
import com.module.db.UserDev;
import com.module.db.UserFrom;
import com.module.db.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/7.
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(String name) {
        try {
            return jdbcTemplate.execute("select * from `user` where `name` = '"+name.trim()+"'", new PreparedStatementCallback<User>() {
                @Override
                public User doInPreparedStatement(PreparedStatement cs) throws SQLException, DataAccessException {
                    ResultSet rs = cs.executeQuery();
                    if(rs.next()){
                        try {
                            return User.instance.create(rs);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return null;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public int insertUser(User user) {
        try {
            int id = this.insert(jdbcTemplate,"INSERT INTO USER(`name`,`password`,`group`,create_time)VALUES(?,?,?,?,?)",
                    user.getName(),user.getPassword(),user.getGroup(),user.getCreateTime());
            return id;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return 0;
    }

/*
    @Override
    public int getUserFrom(String userSrc) {
        try {
            Object obj = this.executesOneResult(jdbcTemplate,"SELECT id FROM `user_from` WHERE user_src = ? ",userSrc);
            if(obj == null){
                return 0;
            }

            return (int) obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return 0;
    }

    @Override
    public int insertFrom(UserFrom from) {
        try {
            int id = this.insert(jdbcTemplate,"INSERT INTO user_from(user_src,serial_num,info,create_date)VALUES(?,?,?,?)",
                    from.getUserSrc(), from.getSerialNum(), from.getInfo(), from.getCreateDate());
            return id;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return 0;
    }*/
}
