package com.lgame.manage.action;


import com.lgame.manage.service.LoginService;
import com.lgame.manage.service.UserService;
import com.lgame.model.User;
import com.lgame.utils.AppException;
import com.lgame.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value={"/server"})
public class ServerAction {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	/**
	 * 登陆后台处理
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/logined"})
	public String login(User user, HttpServletRequest request, HttpSession session){
		if(user == null || "GET".equals(request.getMethod())){
			return "redirect:login";
		}else if(StringUtil.isEmpty(user.getName()) || StringUtil.isEmpty(user.getPassword())){
			session.setAttribute("msg","用户名或密码不能为空");
		}
		try {
			user = loginService.login(user);
			if(user != null){
				return "redirect:main";
			}else{
				session.setAttribute("msg","用户名不存在或者密码错误");
			}
		} catch (AppException e) {
			session.setAttribute("msg",e.getMessage());
		}
		return "redirect:login";
	}

	/**
	 * 跳转主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value={"/menus"},method=RequestMethod.GET)
	public String toMain(HttpServletRequest request, HttpServletResponse response){
		return "main";
	}

	/**
	 * 跳转登陆页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value={"/login"},method=RequestMethod.GET)
	public String toLogin(HttpServletRequest request, HttpServletResponse response){
		return "login";
	}
	/**
	 * 返回默认主页主题
	 * @return
	 */
	@RequestMapping(value={"/default"},method=RequestMethod.GET)
	public String getDefault(){
		return "default";
	}

}
