package com.lgame.manage.service;
import com.lgame.model.*;
import com.module.db.UserInfo;
import org.springframework.stereotype.Repository;

import com.lgame.utils.AppException;

import javax.servlet.http.HttpSession;

@Repository
public interface LoginService {
	/**
	 * @param user
	 * @return
	 * @throws AppException
	 */
	public boolean login(User user) throws AppException;

}
