package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        // 1. 스프링 IOC 컨테이너를 생성한다.
    	GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
        
        // 2. 스프링 IoC 컨테이너로부터 객체를 검색한다.
        TV tv = (TV) container.getBean("lg");
        
//        TV tv2 = (TV) container.getBean("tv");
//        TV tv3 = (TV) container.getBean("tv");
        // getBean을 여러번 하더라도, 새로 객체를 생성하지 않고 이미 생성된 객체를 반납한다.(scope가 default나 singleton인 경우) 
//        System.out.println(tv1.toString());
//        System.out.println(tv2.toString());
//        System.out.println(tv3.toString());
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        
        // 3. 스프링 IoC 컨테이너를 종료한다.
        // 컨테이너는 종료되기 직전에 관리하던 모든 객체를 삭제한다.
        container.close();
    }
}
