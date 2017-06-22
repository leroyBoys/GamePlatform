package com.lgame.model;

import com.mysql.impl.DbFactory;

import java.io.Serializable;
import java.sql.ResultSet;

/**
 * Created by leroy:656515489@qq.com
 * 2017/6/21.
 */
public class UserGroup extends DbFactory implements Serializable {
    public static UserGroup instance = new UserGroup();
    private int id;
    private String name;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public UserGroup create(ResultSet rs) throws Exception {
        UserGroup userGroup = new UserGroup();
        userGroup.setId(rs.getInt("id"));
        userGroup.setName(rs.getString("name"));
        userGroup.setContent(rs.getString("content"));
        return userGroup;
    }

    @Override
    protected UserGroup createNew() {
        return new UserGroup();
    }
}
