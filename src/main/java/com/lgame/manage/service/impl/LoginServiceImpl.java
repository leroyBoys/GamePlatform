package com.lgame.manage.service.impl;

import com.lgame.manage.service.LoginService;
import com.lgame.manage.service.ServerService;
import com.lgame.manage.service.UserService;
import com.lgame.model.User;
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

	public boolean login(User user) throws AppException {
		String userList = PropertiesUtils.getValue("user");
		String name;
		String pwd;
		for(String userStr : userList.split(",")){
			if(StringUtil.isEmpty(userStr)){
				continue;
			}
			name = userStr.split(":")[0].substring(1);
			pwd = userStr.split(":")[1].substring(0,userStr.split(":")[1].length()-1);
			if(name.equals(user.getName())){
				if(pwd.equals(user.getPassword())){
					return true;
				}else{
					throw new AppException("error");
				}
			}
		}
		return false;
	}

}
