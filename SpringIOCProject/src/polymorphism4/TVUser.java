package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        // 1. ������ IOC �����̳ʸ� �����Ѵ�.
    	GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
        
        // 2. ������ IoC �����̳ʷκ��� ��ü�� �˻��Ѵ�.
        TV tv = (TV) container.getBean("lg");
        
//        TV tv2 = (TV) container.getBean("tv");
//        TV tv3 = (TV) container.getBean("tv");
        // getBean�� ������ �ϴ���, ���� ��ü�� �������� �ʰ� �̹� ������ ��ü�� �ݳ��Ѵ�.(scope�� default�� singleton�� ���) 
//        System.out.println(tv1.toString());
//        System.out.println(tv2.toString());
//        System.out.println(tv3.toString());
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        
        // 3. ������ IoC �����̳ʸ� �����Ѵ�.
        // �����̳ʴ� ����Ǳ� ������ �����ϴ� ��� ��ü�� �����Ѵ�.
        container.close();
    }
}
