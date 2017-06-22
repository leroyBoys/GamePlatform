package com.lgame.model;

import com.mysql.impl.DbFactory;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
public class UrlMenu extends DbFactory implements Serializable {
    public static UrlMenu instance = new UrlMenu();
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

    @Override
    public UrlMenu create(ResultSet rs) throws Exception {
        UrlMenu urlMenu = createNew();
        urlMenu.setId(rs.getInt("id"));
        urlMenu.setUrl(rs.getString("url"));
        urlMenu.setUrlDesc(rs.getString("url_desc"));
        urlMenu.setUrlName(rs.getString("url_name"));
        urlMenu.setUrlMenuFlag(rs.getInt("url_menu_flag"));
        return urlMenu;
    }

    @Override
    protected UrlMenu createNew() {
        return new UrlMenu();
    }
}
