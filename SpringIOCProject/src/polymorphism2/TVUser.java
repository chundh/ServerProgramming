package polymorphism2;

/**
 * 다형성 : 상속 + Override + 형변환으로 구성된다.
 * 하나의 인터페이스가 여러개의 구현객체를 받을 수 있게 만든다.
 */

public class TVUser {
    public static void main(String[] args) {
        // interface는 인스턴스 생성이 불가능하지만 구현객체로의 형변환은 가능하다.
        TV tv = new SamsumgTV();
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
    }
}
