package com.zixue.common.utils.filter;

import com.alibaba.druid.support.http.StatViewServlet;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = { "/druid/*" }, initParams = {
		@javax.servlet.annotation.WebInitParam(name = "allow", value = "127.0.0.1"),
		@javax.servlet.annotation.WebInitParam(name = "deny", value = "192.168.16.111"),
		@javax.servlet.annotation.WebInitParam(name = "loginUsername", value = "root"),
		@javax.servlet.annotation.WebInitParam(name = "loginPassword", value = "root"),
		@javax.servlet.annotation.WebInitParam(name = "resetEnable", value = "false") })
public class DruidStatViewServlet extends StatViewServlet {
}
