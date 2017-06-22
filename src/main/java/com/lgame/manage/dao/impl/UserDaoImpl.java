package com.lgame.manage.dao.impl;

import com.lgame.base.dao.BaseDao;
import com.lgame.manage.dao.UserDao;
import com.lgame.model.*;
import com.module.db.UserAttrbute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/7.
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate_plat;

    @Override
    public User getUser(String name) {
        try {
            return jdbcTemplate_plat.execute("select * from `user` where `name` = '"+name.trim()+"'", new PreparedStatementCallback<User>() {
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
            int id = this.insert(jdbcTemplate_plat,"INSERT INTO USER(`name`,`password`,`group`,create_time)VALUES(?,?,?,?,?)",
                    user.getName(),user.getPassword(),user.getGroup(),user.getCreateTime());
            return id;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return 0;
    }

    @Override
    public List<UrlMenu> getAllUrlMenus() {
        try {
            return jdbcTemplate_plat.execute("SELECT * FROM `url_menu` ", new PreparedStatementCallback<List<UrlMenu>>() {
                @Override
                public List<UrlMenu> doInPreparedStatement(PreparedStatement cs) throws SQLException, DataAccessException {
                    ResultSet rs = cs.executeQuery();
                    List<UrlMenu> menus = new LinkedList<>();
                    try {
                        while (rs.next()){
                            menus.add(UrlMenu.instance.create(rs));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return menus;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public int insertIntoUrlMenu(UrlMenu urlMenu) {
        try {
            int id = this.insert(jdbcTemplate_plat,"INSERT INTO `url_menu`(url,url_name,url_menu_flag,url_desc) VALUES (?,?,?,?)",
                    urlMenu.getUrl(),urlMenu.getUrlName(),urlMenu.getUrlMenuFlag(),urlMenu.getUrlDesc());
            return id;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return 0;
    }

    @Override
    public Set<Integer> getUrlsByGroup(int group) {
        try {
            return jdbcTemplate_plat.execute("SELECT url_id FROM `group_limit` WHERE group_id =  "+group, new PreparedStatementCallback<Set<Integer>>() {
                @Override
                public Set<Integer> doInPreparedStatement(PreparedStatement cs) throws SQLException, DataAccessException {
                    ResultSet rs = cs.executeQuery();
                    Set<Integer> urlIds = new HashSet<>();
                    while (rs.next()){
                        urlIds.add(rs.getInt("url_id"));
                    }
                    return urlIds;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public boolean insertIntoGroupLimit(GroupLimit limit) {
        try {
            return this.insertNoReturn(jdbcTemplate_plat,"insert into group_limit(group_id,url_id) values (?,?)",
                    limit.getGroupId(),limit.getUrlId());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return false;
    }

    @Override
    public List<UserLimit> getUserLimitByUid(int uid) {
        try {
            return jdbcTemplate_plat.execute("select * from `user_limit` where uid =  "+uid, new PreparedStatementCallback<List<UserLimit>>() {
                @Override
                public List<UserLimit> doInPreparedStatement(PreparedStatement cs) throws SQLException, DataAccessException {
                    ResultSet rs = cs.executeQuery();
                    List<UserLimit> userLimits = new LinkedList<>();
                    try{
                        while (rs.next()){
                            userLimits.add(UserLimit.instance.create(rs));
                        }
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                    return userLimits;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public boolean insertUserLimit(UserLimit userLimit) {
        try {
            return this.insertNoReturn(jdbcTemplate_plat,"instr into user_limit(uid,extra_type,url_id) values (?,?,?)",
                    userLimit.getUrlId(),userLimit.getExtraType().name(),userLimit.getUrlId());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return false;
    }

    @Override
    public UserAttrbute getUserAttrbute(int uid) {
        try {
            return jdbcTemplate_plat.execute("SELECT * FROM `user_attribute` WHERE id =  "+uid, new PreparedStatementCallback<UserAttrbute>() {
                @Override
                public UserAttrbute doInPreparedStatement(PreparedStatement cs) throws SQLException, DataAccessException {
                    ResultSet rs = cs.executeQuery();
                    if (rs.next()){
                        try {
                            return UserAttrbute.instance.create(rs);
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
    public int insertUserAttribute(UserAttrbute userAttrbute) {
        try {
            return this.insert(jdbcTemplate_plat,"INSERT INTO user_attribute(id,address,email,identity_card,mobile,qq,real_name,sex) VALUES (?,?,?,?,?,?,?,?)",
                    userAttrbute.getId(),userAttrbute.getAddress(),userAttrbute.getEmail(),userAttrbute.getIdentityCard(),userAttrbute.getMobile(),
                    userAttrbute.getQq(),userAttrbute.getRealName(),userAttrbute.getSex());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return 0;
    }

    @Override
    public List<UserGroup> getUserGroups() {
        try {
            return jdbcTemplate_plat.execute("select * from `user_group`", new PreparedStatementCallback<List<UserGroup>>() {
                @Override
                public List<UserGroup> doInPreparedStatement(PreparedStatement cs) throws SQLException, DataAccessException {
                    ResultSet rs = cs.executeQuery();
                    List<UserGroup> goups = new LinkedList<>();
                    if (rs.next()){
                        try {
                            goups.add(UserGroup.instance.create(rs));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return goups;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public int insertUserGroup(UserGroup userGroup) {
        try {
            return this.insert(jdbcTemplate_plat,"insert into `user_group`(`name`,content) values (?,?)",
                    userGroup.getName(),userGroup.getContent());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return 0;
    }

}
