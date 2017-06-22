package com.lgame.manage.service.impl;

import com.lgame.manage.cache.ServerCache;
import com.lgame.manage.service.LoginService;
import com.lgame.manage.service.ServerService;
import com.lgame.manage.service.UserService;
import com.lgame.model.UrlMenu;
import com.lgame.model.User;
import com.lgame.model.UserLimit;
import com.lgame.util.encry.MD5Tool;
import com.lgame.utils.AppException;
import com.lgame.utils.PropertiesUtils;
import com.lgame.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private ServerService serverService;
	@Autowired
	private UserService userService;

	public User login(User user) throws AppException {
		User u = userService.getUser(user.getName());
		if(u == null || !MD5Tool.GetMD5Code(user.getPassword()).equals(u.getPassword())){
			return null;
		}

		u.setUrls(ServerCache.getInstance().getUrlsByGroup(u.getGroup()));
		List<UserLimit> urls = userService.getUserLimitByUid(u.getId());
		if(urls != null){
			for(UserLimit userLimit:urls){
				UrlMenu urlMenu = ServerCache.getInstance().getUrlMenu(userLimit.getUrlId());
				if(urlMenu == null){
					continue;
				}

				if(userLimit.getExtraType() == UserLimit.ExtraType.no){
					u.getUrls().remove(urlMenu.getUrl());
				}else {
					u.getUrls().add(urlMenu.getUrl());
				}
			}
		}

		return u;
	}

}
