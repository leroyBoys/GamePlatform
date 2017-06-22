package com.lgame.manage.cache;

import com.lgame.model.UrlMenu;
import com.lgame.model.UserGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leroy:656515489@qq.com
 * 2017/6/22.
 */
public class ServerCache {
    private static ServerCache ourInstance = new ServerCache();
    public static ServerCache getInstance() {
        return ourInstance;
    }
    private ServerCache() {}

    private List<UserGroup> userGroups = new ArrayList<>();
    private Map<Integer,UrlMenu> urlMenus = new HashMap<>();
    private Map<Integer,Integer> groupLimitMap = new HashMap<>();//groupId--urlid


}
