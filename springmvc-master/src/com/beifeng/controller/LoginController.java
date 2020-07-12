package com.beifeng.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class LoginController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String userName = request.getParameter("userName");
		String userPw = request.getParameter("userPw");
		System.out.println("------����springMVC�Ŀ�����---------");
		System.out.println("账号："+userName);
		System.out.println("密码："+userPw);
		
		ModelAndView mav = new ModelAndView("index");
		
		int i=0;
		
		//ģ�����Model
		if("北京".equals(userName)) {
			i=0;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("湖北".equals(userName)) {
			i=1;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("广东".equals(userName)) {
			i=2;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("辽宁".equals(userName)) {
			i=3;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("云南".equals(userName)) {
			i=4;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("吉林".equals(userName)) {
			i=5;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("湖南".equals(userName)) {
			i=6;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("甘肃".equals(userName)) {
			i=7;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("福建".equals(userName)) {
			i=8;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("广西".equals(userName)) {
			i=9;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("黑龙江".equals(userName)) {
			i=10;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("浙江".equals(userName)) {
			i=11;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("安徽".equals(userName)) {
			i=12;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("内蒙古".equals(userName)) {
			i=13;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("山东".equals(userName)) {
			i=14;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("贵州".equals(userName)) {
			i=15;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("西藏".equals(userName)) {
			i=16;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("江西".equals(userName)) {
			i=17;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("四川".equals(userName)) {
			i=18;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("江苏".equals(userName)) {
			i=19;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("黑龙江".equals(userName)) {
			i=20;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("河南".equals(userName)) {
			i=21;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("河北".equals(userName)) {
			i=22;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("山西".equals(userName)) {
			i=23;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("新疆".equals(userName)) {
			i=24;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("青海".equals(userName)) {
			i=25;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("陕西".equals(userName)) {
			i=26;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		if("天津".equals(userName)) {
			i=28;
			String[] s = userPw.split("-");
			int month =Integer.parseInt(s[1]);
			int day =Integer.parseInt(s[2]);
			String d = "";
			for(int i1 =0;i1<7;i1++)
			d += Integer.toString(month)+'.'+Integer.toString(day+i1)+',';
			String x=SocketTest.test(i,month,day);
			System.out.println("test11");
			mav.addObject("message1", d+x);
			return mav;
		}
		return mav;
	}

}


