package com.lgame.model;

import com.mysql.impl.DbFactory;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by leroy:656515489@qq.com
 * 2017/6/22.
 */
public class GroupLimit extends DbFactory implements Serializable {
    public static GroupLimit instance;
    private int id;
    private int groupId;
    private int urlId;

    private Set<String> urls = new HashSet<>();
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUrlId() {
        return urlId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    @Override
    public GroupLimit create(ResultSet resultSet) throws Exception {
        GroupLimit limit = createNew();
        limit.setId(resultSet.getInt("id"));
        limit.setGroupId(resultSet.getInt("group_id"));
        limit.setUrlId(resultSet.getInt("url_id"));
        return limit;
    }

    @Override
    protected GroupLimit createNew() {
        return new GroupLimit();
    }
}
