<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.lgame.manage.cache.ServerCache" %>
<%@ page import="com.lgame.model.UrlMenu" %>
<%@ page import="com.lgame.model.User" %>
<div data-options="region:'west',split:true" title="管理菜单" style="width:150px;padding:0px;">
			<div id="menu" class="easyui-accordion" data-options="fit:true,border:false">
				<%--<div title="游戏数据管理" id="staticDb" style="padding:0px;overflow: show">
				</div>--%>
				<%
					User user = (User) request.getSession().getAttribute("cur_user");
					List<UrlMenu> urlMenus = ServerCache.getInstance().getMainMenus();
					for(UrlMenu urlMenu:urlMenus){
						if(user.hasUrl(urlMenu.getUrl())){
							%>
							<div title="<%= urlMenu.getUrlName()%>" style="padding:0px;overflow:show">
								<%
									for(UrlMenu child:urlMenu.getMenus()){
										%>
											<a class="staticDb" title="<%= child.getUrlName()%>" rel="<%= child.getUrlName()%>" url="<%= child.getUrl()%>"><%= child.getUrlName()%></a>
										<%
									}
								%>
							</div>
							<%
						}
					}
				%>
				<%--<div title="游戏数据管理" id="staticDb" style="padding:0px;overflow: show">
				</div>
				<div title="用户信息管理"  id="dynamicDb" style="padding:0px;overflow:show">
<!-- 				    <div id="character" title = "user_character" onclick = addDynamicDb()>君主表信息</div> -->
				    <a class="staticDb" title="君主表信息" rel="君主表信息" url="dynamic/toDynamic">君主表信息</a>

				</div>
				<div title="GM" style="padding:0px;overflow:show">
					<a class="staticDb" title="本服务器日志" rel="本服务器日志" url="gm/tolog?type=1">本服务器日志</a>
					<a class="staticDb" title="游戏服务器" rel="游戏服务器" url="gm/tolog?type=2">游戏服务器日志</a>
				    <a class="staticDb" title="消息接口测试" rel="消息测试" url="/gm/ts">消息接口测试</a>
				</div>--%>
			</div>
</div>
