package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        // 1. ������ IOC �����̳ʸ� �����Ѵ�.
    	GenericXmlApplicationContext container = 
    	new GenericXmlApplicationContext("applicationContext.xml");
        
        
//        TV tv = (TV) factory.getBean(args[0]);
//        tv.powerOn();
//        tv.volumeUp();
//        tv.volumeDown();
//        tv.powerOff();
    }
}
