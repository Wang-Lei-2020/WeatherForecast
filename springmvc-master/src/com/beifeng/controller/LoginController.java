package com.beifeng.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.websocket.WebSocketServlet;

public class LoginController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String userName = request.getParameter("userName");
		String userPw = request.getParameter("userPw");
		System.out.println("------我是springMVC的控制器---------");
		System.out.println("账号："+userName);
		System.out.println("账号："+userPw);
		
		ModelAndView mav = new ModelAndView("index");
		
		//模拟调用Model
		if("admin".equals(userName) && "123".equals(userPw)){
			mav.addObject("message", "用户登录成功!");
			
		}else{
			mav.addObject("message", "账号或密码错误！");
		}
	
		
		return mav;
	}

}


