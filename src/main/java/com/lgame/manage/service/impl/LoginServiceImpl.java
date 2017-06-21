package com.lgame.manage.service.impl;

import com.lgame.manage.service.LoginService;
import com.lgame.manage.service.ServerService;
import com.lgame.manage.service.UserService;
import com.lgame.model.User;
import com.lgame.util.encry.MD5Tool;
import com.lgame.utils.AppException;
import com.lgame.utils.PropertiesUtils;
import com.lgame.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return u;
	}

}
