package com.lgame.manage.cache;

import com.lgame.manage.dao.UserRedis;
import com.lgame.manage.service.ServerService;
import com.lgame.manage.service.UserService;
import com.lgame.model.GroupLimit;
import com.lgame.model.UrlMenu;
import com.module.net.DB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 */
public class GateServerCache {
    private static final Logger logger = LoggerFactory.getLogger(GateServerCache.class);
    @Autowired
    private ServerService serverService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRedis userRedis;
    public void start() {
        initServerManager();
    }

    private void initServerManager(){
        List<UrlMenu> urlMenus =  userService.getAllUrlMenus();
        if(urlMenus != null){
            for(UrlMenu menu:urlMenus){
                ServerCache.getInstance().addUrlMenu(menu.getId(),menu);
            }
        }

        List<GroupLimit> groupLimits = userService.getGroupLimits();
        ServerCache.getInstance().setGouplimits(groupLimits);

        ServerCache.getInstance().refrshMainMenus();
        List<ServerConnection> servers = serverService.getGateServers();
        ServerManager.getIntance().init(servers);
    }

    public void destroy() {
    }
}
