package polymorphism1;

public class LgTV {
    public LgTV() {
        System.out.println("===> LgTV 생성");
    }
    public void powerOn(){
        System.out.println("LgTV---전원킨다");
    }
    public void powerOff(){
        System.out.println("LgTV---전원끈다");
    }
    public void volumeUp(){
        System.out.println("LgTV---소리 올린다");
    }
    public void volumeDown(){
        System.out.println("LgTV---소리 내린다");
    }
}
