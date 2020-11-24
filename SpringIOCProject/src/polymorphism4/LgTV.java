package polymorphism4;

public class LgTV implements TV {
    public LgTV() {
        System.out.println("===> LgTV ?ƒ?„±");
    }
    @Override
    public void powerOn(){
        System.out.println("LgTV---? „?›?‚¨?‹¤");
    }
    @Override
    public void powerOff(){
        System.out.println("LgTV---? „?›?ˆ?‹¤");
    }
    @Override
    public void volumeUp(){
        System.out.println("LgTV---?†Œë¦? ?˜¬ë¦°ë‹¤");
    }
    @Override
    public void volumeDown(){
        System.out.println("LgTV---?†Œë¦? ?‚´ë¦°ë‹¤");
    }
}
