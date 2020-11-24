package polymorphism2;

public class SamsumgTV implements TV {
    public SamsumgTV() {
        System.out.println("===> SamsungTV 생성");
    }
    @Override
    public void powerOn(){
        System.out.println("SamsungTV---전원킨다");
    }
    @Override
    public void powerOff(){
        System.out.println("SamsungTV---전원끈다");
    }
    @Override
    public void volumeUp(){
        System.out.println("SamsungTV---소리 올린다");
    }
    @Override
    public void volumeDown(){
        System.out.println("SamsungTV---소리 내린다");
    }
}
