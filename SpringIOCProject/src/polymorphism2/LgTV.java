package polymorphism2;

public class LgTV implements TV{
    public LgTV() {
        System.out.println("===> LgTV 생성");
    }
    @Override
    public void powerOn(){
        System.out.println("LgTV---전원킨다");
    }
    @Override
    public void powerOff(){
        System.out.println("LgTV---전원끈다");
    }
    @Override
    public void volumeUp(){
        System.out.println("LgTV---소리 올린다");
    }
    @Override
    public void volumeDown(){
        System.out.println("LgTV---소리 내린다");
    }
}
