package polymorphism3;

/**
 * main에서 객체를 직접 생성하지 않고, factory로부터 객체를 받아온다.
 * 겉으로 보기에 어떤 객체가 올지 알 수 없다. -> Encapsulation
 * 유지보수를 쉽게 하기 위해서는 코드의 변화를 최소화 해야한다.
 */

public class TVUser {
    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();
        TV tv = (TV) factory.getBean(args[0]);
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
    }
}
