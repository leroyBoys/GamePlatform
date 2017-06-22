package com.lgame.filter;

import com.lgame.model.User;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckUserFilter  implements Filter {
    private final Set<String> commonList = new HashSet<>();
    private final Set<String> commonMenu = new HashSet<>();
    private final static String LOGIN_PREFIX = "/login";
    private static String LOGIN_URL = "/login";

    public void init(FilterConfig filterConfig) throws ServletException {
        commonList.add("/static");
        LOGIN_URL = filterConfig.getServletContext().getContextPath()+LOGIN_URL;
    }

    private void initCommonMenu(){
        commonMenu.add(LOGIN_URL);

    }

    public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String uri = request.getServletPath();
        if(uri.startsWith(LOGIN_PREFIX)){
            chain.doFilter(req, resp);
            return;
        }

        String firstUrlChar = uri.substring(0,Math.min(uri.length(),7));
        boolean isWhite = uri.length() <= 1?false: commonList.contains(firstUrlChar);//白名单

        if(isWhite){
            chain.doFilter(req, resp);
            return;
        }
        User user = (User) session.getAttribute("cur_user");

        if(user==null){
            request.setAttribute("msg", "请先登录");
            response.sendRedirect(LOGIN_URL);//跳转到登陆页
            return;
        }

        System.out.println("===>uri:"+uri);
        if(!commonMenu.contains(uri) && !user.hasUrl(uri)){
            request.setAttribute("msg", "权限错误");
            return;
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}
