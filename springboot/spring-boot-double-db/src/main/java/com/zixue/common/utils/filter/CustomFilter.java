//
//package com.zixue.common.utils.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//@Component
//@WebFilter(filterName = "customFilter", urlPatterns = "/*")
//public class CustomFilter implements Filter {
//	@Autowired
//	private StringRedisTemplate redis;
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("init filter");
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//	    HttpServletResponse res = (HttpServletResponse) response;
//	    HttpSession session = req.getSession(true);
//	    
//	    String currentURL = req.getRequestURI();//截取当前文件名用于比较
//	    if("/login".equals(currentURL)||"/".equals(currentURL)){
//	     System.out.println("欢迎来到登录页面");
//	    chain.doFilter(req, res);
//	    }else{
//	     //从session里取的用户名信息
//	    String username = (String) session.getAttribute("login_admin_test_key");
//	    
//	    //判断如果没有取到用户信息,就跳转到登陆页面
//	     if (username == null || "".equals(username)) {
//	       //跳转到登陆页面
//	       res.sendRedirect("http://"+req.getHeader("Host")+"/login");
////	       req.getRequestDispatcher("/login").forward(req, res);
//	     }
//	     else {
//	       //已经登陆,继续此次请求
//	       chain.doFilter(req,res);
//	     }
//	    }
//		
//	}
//
//	@Override
//	public void destroy() {
//		System.out.println("destroy filter");
//	}
//
//}
