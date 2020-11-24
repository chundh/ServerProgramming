package com.rubypaper.web.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletEngineListener implements ServletContextListener {

//    public ServletEngineListener() {
//        System.out.println("===> ServletEngineListener 생성");
//    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("---> 서블릿 엔진이 생성된 직후에 무조건 실행");
    }
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
        System.out.println("---> 서블릿 엔진이 삭제되기 직전에 무조건 실행");
    }	
}
