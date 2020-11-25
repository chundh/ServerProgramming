package com.rubypaper.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;


public class UserServiceClient {
	public static void main(String[] args) {
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		
		UserService service = (UserService) container.getBean("userService");
		if(service != null) {
			System.out.println(service + " : lookup ¼º°ø");
		}
		UserVO vo = new UserVO();
		vo.setId("admin");
		vo.setPassword("admin");
		System.out.println(service.getUser(vo).toString());
	}
		
}
