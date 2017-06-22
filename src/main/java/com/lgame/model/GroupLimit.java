package com.lgame.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by leroy:656515489@qq.com
 * 2017/6/22.
 */
public class GroupLimit {
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

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }
}
