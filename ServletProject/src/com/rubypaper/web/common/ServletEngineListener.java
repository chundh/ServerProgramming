package com.rubypaper.web.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletEngineListener implements ServletContextListener {

//    public ServletEngineListener() {
//        System.out.println("===> ServletEngineListener ����");
//    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("---> ���� ������ ������ ���Ŀ� ������ ����");
    }
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
        System.out.println("---> ���� ������ �����Ǳ� ������ ������ ����");
    }	
}
