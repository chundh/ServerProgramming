package polymorphism4;

public class SamsungTV implements TV {
    public SamsungTV() {
        System.out.println("===> SamsungTV ?ƒ?„±");
    }
    @Override
    public void powerOn(){
        System.out.println("SamsungTV---? „?›?‚¨?‹¤");
    }
    @Override
    public void powerOff(){
        System.out.println("SamsungTV---? „?›?ˆ?‹¤");
    }
    @Override
    public void volumeUp(){
        System.out.println("SamsungTV---?†Œë¦? ?˜¬ë¦°ë‹¤");
    }
    @Override
    public void volumeDown(){
        System.out.println("SamsungTV---?†Œë¦? ?‚´ë¦°ë‹¤");
    }
}
