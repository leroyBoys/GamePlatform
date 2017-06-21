package com.lgame.model;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
public class UrlMenu {
    private int id;
    private String url;
    private String urlName;
    private int urlMenuFlag;
    private String urlDesc;

    private List<UrlMenu> menus;

    public List<UrlMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<UrlMenu> menus) {
        this.menus = menus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public int getUrlMenuFlag() {
        return urlMenuFlag;
    }

    public void setUrlMenuFlag(int urlMenuFlag) {
        this.urlMenuFlag = urlMenuFlag;
    }

    public String getUrlDesc() {
        return urlDesc;
    }

    public void setUrlDesc(String urlDesc) {
        this.urlDesc = urlDesc;
    }
}
