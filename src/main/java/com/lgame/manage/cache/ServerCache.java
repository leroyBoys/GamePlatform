package com.lgame.manage.cache;

import com.lgame.model.GroupLimit;
import com.lgame.model.UrlMenu;
import com.lgame.model.UserGroup;

import java.util.*;

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

    private Map<Integer,UrlMenu> urlMenus = new HashMap<>();
    private List<GroupLimit> gouplimits = new ArrayList<>();

    private List<UrlMenu> mainMenus = new ArrayList<>();

    public void addUrlMenu(Integer id,UrlMenu menu){
        urlMenus.put(id,menu);
    }

    public void addGroupLimit(GroupLimit groupLimit){
        this.gouplimits.add(groupLimit);
    }

    public void setGouplimits(List<GroupLimit> gouplimits) {
        this.gouplimits = gouplimits;
    }

    public Set<String> getUrlsByGroup(int group){
        Set<String> urls = new HashSet<>();
        for(GroupLimit groupLimit: gouplimits){
            if(group == groupLimit.getGroupId()){
                UrlMenu urlMenu = urlMenus.get(groupLimit.getUrlId());
                if(urlMenu == null){
                    continue;
                }
                urls.add(urlMenu.getUrl());
            }
        }
        return urls;
    }

    public UrlMenu getUrlMenu(int urlId) {
        return urlMenus.get(urlId);
    }

    public List<UrlMenu> getMainMenus() {
        return mainMenus;
    }

    public void refrshMainMenus(){
        mainMenus.clear();
        Map<Integer,UrlMenu> urlMenuMap = new HashMap<>();
        for(Map.Entry<Integer,UrlMenu> entry: urlMenus.entrySet()){
            if(entry.getValue().getUrlMenuFlag() == 0){
                UrlMenu urlMenu = cloneUrlMenu(entry.getValue());
                urlMenu.setMenus(new LinkedList<UrlMenu>());
                mainMenus.add(urlMenu);
                urlMenuMap.put(entry.getKey(),urlMenu);
            }
        }

        for(Map.Entry<Integer,UrlMenu> entry: urlMenus.entrySet()){
            if(entry.getValue().getUrlMenuFlag() > 0){
                UrlMenu urlMenu = urlMenuMap.get(entry.getValue().getUrlMenuFlag());
                if(urlMenu == null){
                    continue;
                }

                urlMenu.getMenus().add(cloneUrlMenu(entry.getValue()));
            }
        }
    }

    private UrlMenu cloneUrlMenu(UrlMenu fromUrlMenu){
        UrlMenu urlMenu = new UrlMenu();
        urlMenu.setUrl(fromUrlMenu.getUrl());
        urlMenu.setUrlName(fromUrlMenu.getUrlName());
        return urlMenu;
    }
}
