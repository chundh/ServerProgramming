package polymorphism4;

public class SamsungTV implements TV {
    public SamsungTV() {
        System.out.println("===> SamsungTV ?��?��");
    }
    @Override
    public void powerOn(){
        System.out.println("SamsungTV---?��?��?��?��");
    }
    @Override
    public void powerOff(){
        System.out.println("SamsungTV---?��?��?��?��");
    }
    @Override
    public void volumeUp(){
        System.out.println("SamsungTV---?���? ?��린다");
    }
    @Override
    public void volumeDown(){
        System.out.println("SamsungTV---?���? ?��린다");
    }
}
